import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LevelsSelector {
        private JTextArea text_1 = new JTextArea("Level 1");
        private JTextArea text_2 = new JTextArea("Level 2");
        private JTextArea text_3 = new JTextArea("Level 3");
        private JTextArea text_4 = new JTextArea("Level 4");
        private JTextArea text_5 = new JTextArea("Level 5");
        private MenuButton level_1 = new MenuButton("");
        private MenuButton level_2 = new MenuButton("");
        private MenuButton level_3 = new MenuButton("");
        private MenuButton level_4 = new MenuButton("");
        private MenuButton level_5 = new MenuButton("");
        private JPanel pLevel_1 = new JPanel();
        private JPanel pLevel_2 = new JPanel();
        private JPanel pLevel_3 = new JPanel();
        private JPanel pLevel_4 = new JPanel();
        private JPanel pLevel_5 = new JPanel();
        private boolean[] isUnlocked =  {true, false, false, false, false}; // level 1 is always ready to start
        private boolean isPlaying = false; // check if the user is playing
        private Audio player = new Audio();

        private final int LENGTH = 40;
        private final int DEFAULT_X = 100;
        private int defaultY = 0;

        private void findDefault(JFrame frame) { // myb I'll want to change the resolution so I have to find the new values
            this.defaultY = (frame.getHeight() - 5 * LENGTH) / 6;
            System.out.println("Default Y is " + this.defaultY);
        }

        private void playLevel_1() {
            if(isPlaying) return;
            isPlaying = true;
            try {this.player.stop();} catch(Exception e) {e.printStackTrace();};
            // TODO: play level 1
        }

        private void playLevel_2() {
            if(isPlaying) return;
            isPlaying = true;
            try {this.player.stop();} catch(Exception e) {System.out.println(e);};
            // TODO: play level 2
        }

        private void playLevel_3() {
            if(isPlaying) return;
            isPlaying = true;
            try {this.player.stop();} catch(Exception e) {e.printStackTrace();};
            // TODO: play level 3
        }

        private void playLevel_4() {
            if(isPlaying) return;
            isPlaying = true;
            try {this.player.stop();} catch(Exception e) {e.printStackTrace();};
            // TODO: play level 4
        }

        private void playLevel_5() {
            if(isPlaying) return;
            isPlaying = true;
            try {this.player.stop();} catch(Exception e) {e.printStackTrace();};
            // TODO: play level 5
        }

        public void setButtons() {
            // level_1 is always true
            this.level_2.setVisible(this.isUnlocked[1]);
            this.level_3.setVisible(this.isUnlocked[2]);
            this.level_4.setVisible(this.isUnlocked[3]);
            this.level_5.setVisible(this.isUnlocked[4]);
        }

        public void unlockLevel(int level) {
            this.isUnlocked[level] = true;
        }

        LevelsSelector(JFrame frame) {
            findDefault(frame); // find the Y
            this.player.setFile("songs/unknown.wav");
            this.player.play();

            // set the bounds of the panels used for buttons
            this.pLevel_1.setBounds(this.DEFAULT_X, 1 * this.defaultY + 0 * this.LENGTH, this.LENGTH, this.LENGTH); // I want a square tbh
            this.pLevel_2.setBounds(this.DEFAULT_X, 2 * this.defaultY + 1 * this.LENGTH, this.LENGTH, this.LENGTH); // for each button
            this.pLevel_3.setBounds(this.DEFAULT_X, 3 * this.defaultY + 2 * this.LENGTH, this.LENGTH, this.LENGTH);
            this.pLevel_4.setBounds(this.DEFAULT_X, 4 * this.defaultY + 3 * this.LENGTH, this.LENGTH, this.LENGTH);
            this.pLevel_5.setBounds(this.DEFAULT_X, 5 * this.defaultY + 4 * this.LENGTH, this.LENGTH, this.LENGTH);

            // set the bounds of the buttons
            this.level_1.setBounds(0, 0, LENGTH, LENGTH);
            this.level_2.setBounds(0, 0, LENGTH, LENGTH);
            this.level_3.setBounds(0, 0, LENGTH, LENGTH);
            this.level_4.setBounds(0, 0, LENGTH, LENGTH);
            this.level_5.setBounds(0, 0, LENGTH, LENGTH);

            // format the texts + adding the bounds and the same background as the main frame for them
            this.text_1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
            this.text_2.setFont(new Font("Times New Roman", Font.ITALIC, 24));
            this.text_3.setFont(new Font("Times New Roman", Font.ITALIC, 24));
            this.text_4.setFont(new Font("Times New Roman", Font.ITALIC, 24));
            this.text_5.setFont(new Font("Times New Roman", Font.ITALIC, 24));

            this.text_1.setEditable(false);
            this.text_2.setEditable(false);
            this.text_3.setEditable(false);
            this.text_4.setEditable(false);
            this.text_5.setEditable(false);

            this.text_1.setBounds(this.DEFAULT_X + 100, 1 * this.defaultY + 0 * this.LENGTH + 5, 75, 25);
            this.text_2.setBounds(this.DEFAULT_X + 100, 2 * this.defaultY + 1 * this.LENGTH + 5, 75, 25);
            this.text_3.setBounds(this.DEFAULT_X + 100, 3 * this.defaultY + 2 * this.LENGTH + 5, 75, 25);
            this.text_4.setBounds(this.DEFAULT_X + 100, 4 * this.defaultY + 3 * this.LENGTH + 5, 75, 25);
            this.text_5.setBounds(this.DEFAULT_X + 100, 5 * this.defaultY + 4 * this.LENGTH + 5, 75, 25);

            this.text_1.setBackground(new Color(96, 157, 243));
            this.text_2.setBackground(new Color(96, 157, 243));
            this.text_3.setBackground(new Color(96, 157, 243));
            this.text_4.setBackground(new Color(96, 157, 243));
            this.text_5.setBackground(new Color(96, 157, 243));

            this.setButtons(); // I want to see the unlocked levels

            // adding listeners for the buttons
            this.level_1.addActionListener(e -> this.playLevel_1());
            this.level_2.addActionListener(e -> this.playLevel_2());
            this.level_3.addActionListener(e -> this.playLevel_3());
            this.level_4.addActionListener(e -> this.playLevel_4());
            this.level_5.addActionListener(e -> this.playLevel_5());

            // adding all the components
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

            frame.add(this.text_1);
            frame.add(this.text_2);
            frame.add(this.text_3);
            frame.add(this.text_4);
            frame.add(this.text_5);

            // refresh the frame
            frame.repaint();
        }

}
