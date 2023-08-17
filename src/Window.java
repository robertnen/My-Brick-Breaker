import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    private JFrame frame;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 800;
    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 50;
    private final JPanel playPanel = new JPanel();
    private final JPanel infoPanel = new JPanel();
    private final JPanel exitPanel = new JPanel();
    private final JButton playButton = new JButton("Play game");
    private final JButton infoButton = new JButton("Info about the game");
    private final JButton exitButton = new JButton("Exit the game");

    Window() {
        this.frame = new JFrame("My Brick Breaker");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.frame.setResizable(false);
        this.frame.getContentPane().setBackground(new Color(169, 169, 169)); // gray
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
        createMenu();

        this.frame.setVisible(true);
    }

    public void createMenu() {

        this.playPanel.setBounds(200, 280, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.infoPanel.setBounds(200, 380, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.exitPanel.setBounds(200, 480, BUTTON_WIDTH, BUTTON_HEIGHT);

        this.playButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.infoButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        this.exitButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);

        this.playPanel.setBackground(Color.RED);
        this.infoPanel.setBackground(Color.BLUE);
        this.exitPanel.setBackground(Color.GREEN);

        this.playPanel.add(playButton);
        this.infoPanel.add(infoButton);
        this.exitPanel.add(exitButton);

        this.frame.add(playPanel);
        this.frame.add(infoPanel);
        this.frame.add(exitPanel);
    }

    public JFrame getFrame() {return this.frame;}
}
