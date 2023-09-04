import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class GameFrame {
    private JFrame game = new JFrame();
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 800;
    // private Map map = new Map(FRAME_HEIGHT, null)

    GameFrame(int level) {
        this.game.setTitle("Level " + level);
        this.game.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
        this.game.setLayout(null);
        this.game.setLocationRelativeTo(null);
        this.game.setResizable(false);

        ImageIcon icon = new ImageIcon("img/myLogo.png");
        this.game.setIconImage(icon.getImage());
        this.game.getContentPane().setBackground(new Color(96, 157, 243));

        Map map = new Map();
        this.game.add(map);

        this.game.setVisible(true);
    }
}
