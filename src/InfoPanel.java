import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoPanel extends JFrame {

    private int OFFSET = 12;
    private int MARGIN = 460;
    private JPanel backgroundPanel = new JPanel();
    private JTextArea infoText = new JTextArea("Welcome to \"My Break Breaker\" by Lucky8boy!\n\nI hope you'll like it!\n\nGame made using Java.\n\nThere are 5 levels where you have to destroy all the bricks!\n\n~ Lucy");

    InfoPanel(String title, int width, int height, ImageIcon icon) {
        super(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(new Color(135, 206, 235)); // "lighter" blue
        editPanel();
    }

    private void editPanel() {
        this.backgroundPanel.setBounds(OFFSET, OFFSET, MARGIN, 278 + MARGIN);
        this.backgroundPanel.setBackground(new Color(96, 157, 255));
        this.backgroundPanel.setLayout(null);

        this.infoText.setFont(new Font("Monospaced Plain", Font.PLAIN, 40));
        this.infoText.setForeground(Color.BLACK);
        this.infoText.setBackground(new Color(96, 157, 243));
        this.infoText.setBounds(OFFSET + 4, OFFSET + 4, MARGIN - 8, MARGIN + 200);

        this.infoText.setLineWrap(true);
        this.infoText.setWrapStyleWord(true);
        this.infoText.setEditable(false);
        this.backgroundPanel.add(this.infoText);

        this.add(this.backgroundPanel);
    }

}
