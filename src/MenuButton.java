import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class MenuButton extends BasicButtonUI {

    public void installUi(JComponent c) {
        super.installUI(c);
    }

    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
    }


    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton abs = (AbstractButton) c;
    }
}
