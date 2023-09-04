import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Map extends JPanel implements KeyListener, ActionListener {
    private int[][] map = new int[40][10];
    private boolean isWin = false;
    private Timer timer;
    private int timeDelay = 8;
    private int playerBarX = 200;
    private int ballposX = 250;
    private int ballposY = 650;
    private int ballDirX = -1;
    private int ballDirY = -2;
    private int score = 0;
    private int noBricks = 0;
    private boolean isPlaying = true;
    private final int BRICK_WIDTH = 40;
    private final int BRICK_HEIGHT = 10;
    private final int BALL_WIDTH = 10;
    private final int BALL_HEIGHT = 10;

    Map() {
        this.setSize(500, 800);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(timeDelay, this);
        timer.start();
    }

    public boolean getStatus() {
        return this.isWin;
    }

    public void setBrick(int value, int row, int col) {
        this.map[row][col] = value;
        this.noBricks--;
    }

    public void drawMap(Graphics2D g) {
        int x, y;

        for(int i = 0; i < 40; i++)
            for(int j = 0; j < 10; j++) {
                x = 50 + j * BRICK_WIDTH;
                y = i * BRICK_HEIGHT;

                if(this.map[i][j] != 0) this.noBricks++;

                switch(map[i][j]) {
                    case 1:
                        g.setColor(Color.BLUE);
                        break;
                    case 2:
                        g.setColor(Color.red);
                        break;
                    case 3:
                        g.setColor(Color.yellow);
                        break;
                    case 4:
                        g.setColor(Color.green);
                        break;
                    case 5:
                        g.setColor(Color.pink);
                        break;
                    case 6:
                        g.setColor(Color.magenta);
                        break;
                    case 7:
                        g.setColor(Color.gray);
                        break;
                    case 8:
                        g.setColor(Color.white);
                        break;
                    case 9:
                        g.setColor(Color.lightGray);
                        break;
                    default:
                        continue;
                        // System.out.println("The value is not right (" + i + ", " + j + ")!");
                        // break;
                }

                g.fillRect(x + 1, y + 1, BRICK_WIDTH - 1, BRICK_HEIGHT - 1);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        g.fillRect(0, 0, 500, 800);

        g.setColor(Color.lightGray);
        g.fillRect(50, 0, 400, 800);
        g.setColor(Color.BLACK);

        g.setColor(Color.green);
        g.fillRect(playerBarX, 700, 100, 20);

        g.setColor(Color.red);
        g.fillOval(ballposX, ballposY, BALL_WIDTH, BALL_HEIGHT);

        try { this.readMap("levels/level_1.txt"); } catch (FileNotFoundException e) { System.out.println("No"); }

        drawMap((Graphics2D)g);

        this.isPlaying = true;

        if(noBricks <= 0) {
            this.isPlaying = false;
            this.isWin = true;
            ballDirX = 0;
            ballDirY = 0;
            g.setColor(new Color(211, 211, 211));
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("Score: " + this.score, 0, 0);
        }

        if(ballposY > 750) { // the player lost the game
            this.isPlaying = false;
            ballDirX = 0;
            ballDirY = 0;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
            g.drawString("You lost... Score: " + this.score, 0, 0);
        }
        g.dispose();
    }

    private void readMap (String filePath) throws FileNotFoundException {
        for(int i = 0; i < 40; i++)
            for(int j = 0; j < 10; j++) this.map[i][j] = 0;

        Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));

        String[] line;
        while(sc.hasNextLine()) {
            for(int i = 0; i < 40; i++) {
                line = sc.nextLine().trim().split(" ");
                for(int j = 0; j < 10; j++) this.map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public void goLeft() {
        this.isPlaying = true;
        this.playerBarX -= 30;
    }

    public void goRight() {
        this.isPlaying = true;
        this.playerBarX += 30;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.timer.start();
        if(this.isPlaying) { // check if I hit the bar
            if(new Rectangle(ballposX, ballposY, BALL_WIDTH, BALL_HEIGHT).intersects(new Rectangle(playerBarX, 700, 100, 20))) {
                this.ballDirY = -this.ballDirY;
            }

            int brickX, brickY;

            for(int i = 0; i < 40; i++)
                for(int j = 0; j < 10; j++)
                    if(this.map[i][j] > 0) {
                        brickX = j * BRICK_WIDTH + 50;
                        brickY = i * BRICK_HEIGHT;

                        Rectangle brickRect = new Rectangle(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, BALL_WIDTH, BALL_HEIGHT);

                        if(ballRect.intersects(brickRect)) {
                            this.score += 5 * map[i][j];
                            setBrick(0, i, j);
                        }

                        if(ballposX + 9 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) ballDirX = -ballDirX;
                        else ballDirY = -ballDirY;
                    }
            ballposX += ballDirX;
            ballposY += ballDirY;

            if(ballposX < 47) ballDirX = -ballDirX;
            if(ballposY < 0) ballDirY = -ballDirY;
            if(ballposX > 447) ballDirX = -ballDirX;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerBarX >= 350) playerBarX = 350;
            else goRight();
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerBarX <= 50) playerBarX = 50;
            else goLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}