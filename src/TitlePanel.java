import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

    private Image bgImg;
    private final int IMAGE_WIDTH = 400;
    private final int IMAGE_HEIGHT = 200;

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);

        // I want to have the image in a rounded rectangle so I'll clip it
        g.setClip(new RoundRectangle2D.Double(0, 0, this.IMAGE_WIDTH, this.IMAGE_HEIGHT, 40, 40));

        g.drawImage(this.bgImg, 0, 0, null);
    }

    TitlePanel(String filepath) {
        this.bgImg = new ImageIcon("img/Title_Image_My_Brick_Breaker.png").getImage();
        Dimension size = new Dimension(this.IMAGE_WIDTH, this.IMAGE_HEIGHT);

        setSize(size);
        setLayout(null);
    }
}
