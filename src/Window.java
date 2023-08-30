import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Window extends JFrame {
    private JFrame infoFrame;                                                           // this is a windows containing info about the game
    private boolean isReady = false;                                                    // false = still in main menu / true = starting the game
    private boolean isUsed = false;                                                     // true if the infoWindow is opened
    private final int MIN_WIDTH = 200;                                                  // minimum size for the buttons on width
    private final int MIN_HEIGHT = 50;                                                  // minimum size for the buttons on heigth
    private Audio player = new Audio();                                                 // audio player made to run the songs
    private final int FRAME_WIDTH = 500;                                                // width of the frame containing the game
    private final int FRAME_HEIGHT = 800;                                               // height of the frame containing the game
    private final JPanel playPanel = new JPanel();                                      // the panel containing the play button
    private final JPanel infoPanel = new JPanel();                                      // the panel containing the info button
    private final JPanel exitPanel = new JPanel();                                      // the panel containing the exit button
    private final JPanel songinfoP = new JPanel();                                      // the panel containing the info about the song
    private JFrame frame = new JFrame("My Brick Breaker");                        // the frame used for the game (still used later)
    private ImageIcon icon = new ImageIcon("img/myLogo.png");                  // the icon used for the game
    private final TitlePanel titlePanel = new TitlePanel("/img/myLogo.png");   // titlepanel used to use a "rounded" rectangle as a mask for the image
    private final MenuButton playButton = new MenuButton("      Play game    ");   // play button text
    private final MenuButton infoButton = new MenuButton("Info about the game");   // info button text
    private final MenuButton exitButton = new MenuButton("    Exit the game  ");   // exit button text
    private JTextArea aboutSong = new JTextArea("\"Beyond the sky\" - Lucky8boy"); // info about the song

    private void playButtonPressed() { // done
        System.out.println("Play button pressed");
        try {
            this.player.stop(); // I want to stop the main menu song "Beyond the sky"
        } catch(Exception e) {
            System.out.println("Song couldn't be stopped!\n" + e);
        }

        if(this.isUsed) this.infoFrame.dispose(); // check if I can dispose of the frame
        this.isReady = true; // go forward
    }

    private void addSongInfo() { // done
        this.songinfoP.setBounds(this.FRAME_WIDTH - 240, this.FRAME_HEIGHT - 100, 340, 40);
        this.songinfoP.setBackground(new Color(96, 157, 243));
        this.songinfoP.setSize(200, 50);

        this.aboutSong.setFont(new Font("Times New Roman", Font.ITALIC, 16));
        this.aboutSong.setBackground(new Color(96, 157, 243));
        this.aboutSong.setForeground(Color.BLACK);
        this.aboutSong.setBounds(0, 0, 340, 40);

        this.aboutSong.setLineWrap(true);       // I want the text to be on more rows
        this.aboutSong.setWrapStyleWord(true);  // and not editable
        this.aboutSong.setEditable(false);

        this.songinfoP.setLayout(null);
        this.songinfoP.add(aboutSong);

        this.frame.add(this.songinfoP);
    }

    private void infoButtonPressed() { // done
        System.out.println("Info button pressed");

        if(this.isUsed) this.infoFrame.dispose(); // if the info window is opened, isUsed is true so I can dispose of it
        else this.isUsed = true;                  // if not, the open the window and remeber that

        this.infoFrame = new InfoPanel("Info about the game", FRAME_WIDTH, FRAME_HEIGHT, icon);
        this.infoFrame.setVisible(true);
    }

    private void exitButtonPressed() { //done
        System.out.println("Exit button pressed");
        try {
            this.player.stop(); // I want to stop the main menu song "Beyond the sky"
        } catch(Exception e) {
            System.out.println("Song couldn't be stopped!\n" + e);
        }
        this.frame.removeAll();
        this.frame.dispose(); // close the game
    }

    Window() {

        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        this.frame.setLayout(null);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setIconImage(icon.getImage());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(96, 157, 243)); // light blue

        this.addSongInfo(); // shows in the bottom right corner the following: "\"Beyond the sky\" - Lucky8boy"

        this.player.setFile("songs/beyond_the_sky.wav"); // the menu song
        this.player.play();

        this.createMenu();

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

    public JFrame getFrame() {return this.frame;}     // get the frame cuz I need it
    public boolean getStatus() {return this.isReady;} // check if the game started
}
