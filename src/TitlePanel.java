import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

    private Image bgImg;
    private final int IMAGE_WIDTH = 400;
    private final int IMAGE_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawImage(this.bgImg, 0, 0, null);
    }

    TitlePanel(String filepath) {
        this.bgImg = new ImageIcon("img/Title_Image_My_Brick_Breaker.png").getImage();
        Dimension size = new Dimension(this.IMAGE_WIDTH, this.IMAGE_HEIGHT);
        // setPreferredSize(size);
        // setMinimumSize(size);
        // setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
}
