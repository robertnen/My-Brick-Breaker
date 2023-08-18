import java.awt.Color;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    private final int MIN_WIDTH = 200;
    private final int MIN_HEIGHT = 50;
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 800;
    private final JPanel playPanel = new JPanel();
    private final JPanel infoPanel = new JPanel();
    private final JPanel exitPanel = new JPanel();
    private JFrame frame = new JFrame("My Brick Breaker");
    private ImageIcon icon = new ImageIcon("img/myLogo.png");
    private final TitlePanel titlePanel = new TitlePanel("/img/myLogo.png");
    private final MenuButton playButton = new MenuButton("      Play game    ");
    private final MenuButton infoButton = new MenuButton("Info about the game");
    private final MenuButton exitButton = new MenuButton("    Exit the game  ");

    private void playButtonPressed() {
        System.out.println("Play button pressed");
    }

    private void infoButtonPressed() {
        System.out.println("Info button pressed");
    }

    private void exitButtonPressed() {
        System.out.println("Exit button pressed");
        this.frame.dispose(); // close the game
    }

    Window() {

        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        this.frame.setLayout(null);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setIconImage(icon.getImage());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(96, 157, 243)); // gray

        createMenu();

        this.frame.setVisible(true);
    }

    public void createMenu() {

        this.titlePanel.setBackground(Color.BLACK);
        this.titlePanel.setBounds(50, 50, 400, 200);

        this.playButton.addActionListener(e -> this.playButtonPressed());
        this.infoButton.addActionListener(e -> this.infoButtonPressed());
        this.exitButton.addActionListener(e -> this.exitButtonPressed());

        this.playPanel.setBounds(150, 360, MIN_WIDTH, MIN_HEIGHT);
        this.infoPanel.setBounds(150, 460, MIN_WIDTH, MIN_HEIGHT);
        this.exitPanel.setBounds(150, 560, MIN_WIDTH, MIN_HEIGHT);

        this.playPanel.setBackground(new Color(96, 157, 243));
        this.infoPanel.setBackground(new Color(96, 157, 243));
        this.exitPanel.setBackground(new Color(96, 157, 243));

        this.playButton.setSize(MIN_WIDTH, MIN_HEIGHT);
        this.infoButton.setSize(MIN_WIDTH, MIN_HEIGHT);
        this.exitButton.setSize(MIN_WIDTH, MIN_HEIGHT);

        this.playPanel.add(playButton);
        this.infoPanel.add(infoButton);
        this.exitPanel.add(exitButton);

        this.frame.add(titlePanel);
        this.frame.add(playPanel);
        this.frame.add(infoPanel);
        this.frame.add(exitPanel);
    }

    public JFrame getFrame() {return this.frame;}
}
