import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    private JFrame frame = new JFrame("My Brick Breaker");
    private JPanel menuPanel = new JPanel();
    private ImageIcon icon = new ImageIcon("img/myLogo.png");
    private final int FRAME_HEIGHT = 800;
    private final int FRAME_WIDTH = 500;

    Window() {

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the program
        this.frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        this.setMenuPanel(); // adds a layer (maybe I want something "under" it later)

        this.frame.setLocationRelativeTo(null); // move to the center of the screen
        this.frame.setIconImage(icon.getImage());
        this.frame.setResizable(false);

        this.frame.setVisible(true);
    }

    public JFrame getFrame() {return this.frame;} // maybe I will need to change something
    private void setMenuPanel() {
        this.menuPanel.setBounds(0, 0, this.FRAME_WIDTH, this.FRAME_HEIGHT);
        this.menuPanel.setBackground(new Color(169, 169, 169));
        this.menuPanel.setVisible(true);
        this.frame.add(menuPanel);
    }
}
