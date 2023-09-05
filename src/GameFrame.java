import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class GameFrame {
    private JFrame game = new JFrame();
    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 800;

    GameFrame(int level) {
        this.game.setTitle("Level " + level);
        this.game.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
        this.game.setLayout(null);
        this.game.setLocationRelativeTo(null);
        this.game.setResizable(false);

        ImageIcon icon = new ImageIcon("img/myLogo.png");
        this.game.setIconImage(icon.getImage());
        this.game.getContentPane().setBackground(new Color(96, 157, 243));

        String songPath = "";

        switch(level) {
            case 1:
                songPath = "songs/faster_than_light.wav";
                break;
            case 2:
                songPath = "songs/break_it.wav";
                break;
            case 3:
                songPath = "songs/ibi_dolor.wav";
                break;
            case 4:
                songPath = "songs/above_the_sea.wav";
                break;
            case 5:
                songPath = "songs/blue_bird.wav";
                break;
            default:
                System.out.println("There are only 5 levels! The game will close!");
                System.exit(1);
                break;
        }

        Map map = new Map(level, game, songPath);
        this.game.add(map);

        this.game.setVisible(true);
        map = null;
    }
}
