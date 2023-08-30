import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelsSelector {
        private MenuButton level_1 = new MenuButton("1");
        private MenuButton level_2 = new MenuButton("2");
        private MenuButton level_3 = new MenuButton("3");
        private MenuButton level_4 = new MenuButton("4");
        private MenuButton level_5 = new MenuButton("5");
        private JPanel pLevel_1 = new JPanel();
        private JPanel pLevel_2 = new JPanel();
        private JPanel pLevel_3 = new JPanel();
        private JPanel pLevel_4 = new JPanel();
        private JPanel pLevel_5 = new JPanel();

        private final int LENGTH = 40;
        private final int DEFAULT_X = 100;
        private int defaultY = 0;

        private void findDefault(JFrame frame) { // myb I'll want to change the resolution so I have to find the new values
            this.defaultY = (frame.getHeight() - 5 * LENGTH) / 6;
            System.out.println("Default Y is " + this.defaultY);
        }

        LevelsSelector(JFrame frame) {
            findDefault(frame); // find the Y

            this.pLevel_1.setBounds(this.DEFAULT_X, 1 * this.defaultY + 0 * this.LENGTH, this.LENGTH, this.LENGTH); // I want a square tbh
            this.pLevel_2.setBounds(this.DEFAULT_X, 2 * this.defaultY + 1 * this.LENGTH, this.LENGTH, this.LENGTH); // for each button
            this.pLevel_3.setBounds(this.DEFAULT_X, 3 * this.defaultY + 2 * this.LENGTH, this.LENGTH, this.LENGTH);
            this.pLevel_4.setBounds(this.DEFAULT_X, 4 * this.defaultY + 3 * this.LENGTH, this.LENGTH, this.LENGTH);
            this.pLevel_5.setBounds(this.DEFAULT_X, 5 * this.defaultY + 4 * this.LENGTH, this.LENGTH, this.LENGTH);

            this.level_1.setBounds(0, 0, LENGTH, LENGTH);
            this.level_2.setBounds(0, 0, LENGTH, LENGTH);
            this.level_3.setBounds(0, 0, LENGTH, LENGTH);
            this.level_4.setBounds(0, 0, LENGTH, LENGTH);
            this.level_5.setBounds(0, 0, LENGTH, LENGTH);


            this.pLevel_1.add(level_1);
            this.pLevel_2.add(level_2);
            this.pLevel_3.add(level_3);
            this.pLevel_4.add(level_4);
            this.pLevel_5.add(level_5);

            frame.add(this.pLevel_1);
            frame.add(this.pLevel_2);
            frame.add(this.pLevel_3);
            frame.add(this.pLevel_4);
            frame.add(this.pLevel_5);

            frame.repaint();
        }

}
