import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {
    private JFrame frame;
    private final int WIDTH = 500;
    private final int HEIGHT = 800;


    Window() {
        this.frame = new JFrame("My Brick Breaker");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setResizable(false);
        this.frame.getContentPane().setBackground(new Color(169, 169, 169)); // gray
        this.frame.setLocationRelativeTo(null);


        this.frame.setVisible(true);
    }

    public JFrame getFrame() {return this.frame;}
}
