import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JPanel;

public class Map extends JPanel {
    private int[][] map = new int[40][10];

    Map(int level, String filePath) {
        try {this.readMap(filePath);} catch (FileNotFoundException e) {e.printStackTrace();}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paint(g);
    }

    private void readMap (String filePath) throws FileNotFoundException {
        for(int i = 0; i < 40; i++)
            for(int j = 0; j < 10; j++) this.map[i][j] = 0;

        Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));

        String[] line;
        while(sc.hasNextLine()) {
            for(int i = 0; i < 40; i++) {
                line = sc.nextLine().trim().split(" ");
                for(int j = 0; j < 10; j++) this.map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
