import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JButton;

public class MenuButton extends JButton {

    private final int OFFSET_RECT = 4;

    MenuButton(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 18));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(211, 211, 211));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(new Color(169, 169, 169));
        g.fillRect(OFFSET_RECT, OFFSET_RECT, getWidth() - 2 * OFFSET_RECT, getHeight() - 2 * OFFSET_RECT);

        g.setColor(Color.black);

        FontMetrics fm = g.getFontMetrics();
        int txtX = (getWidth() - fm.stringWidth(getText())) / 2;
        int txtY = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g.drawString(getText(), txtX, txtY);
    }
}
