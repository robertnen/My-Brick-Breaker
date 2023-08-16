import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuButtons extends JButton {

    private JButton button = new JButton();

    MenuButtons(String name, final int x, final int y, final int w, final int h) {
        this.button.setText(name);
        this.button.setBounds(x, y, w, h);
        this.button.setVisible(true);
        System.out.println("Hello x2");
    }

    public void setPanel(JPanel menuPanel) {menuPanel.add(this.button);}
}
