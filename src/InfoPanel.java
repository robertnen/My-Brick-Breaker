import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InfoPanel extends JFrame {

    private int OFFSET = 12;
    private JPanel backgroundPanel = new JPanel();
    private int width = 0;
    private int height = 0;

    InfoPanel(String title, int width, int height, ImageIcon icon) {
        super(title);
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());

        this.width = width;
        this.height = height;

        this.getContentPane().setBackground(new Color(135, 206, 235)); // "lighter" blue
        editPanel();
    }

    private void editPanel() {
        this.backgroundPanel.setBounds(OFFSET, OFFSET, this.width - 3 * OFFSET, this.height - 2 * OFFSET);
        this.backgroundPanel.setBackground(new Color(96, 157, 255));
        this.backgroundPanel.setLayout(null);

        this.add(this.backgroundPanel);
    }

}
