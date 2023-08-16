import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import javax.swing.JPanel;

public class Menu extends JPanel {

    private MenuButtons playButton = new MenuButtons("Play", 100, 0, 140, 40);
    private MenuButtons infoButton = new MenuButtons("Info", 200, 80, 140, 40);
    private MenuButtons exitButton = new MenuButtons("Exit", 300, 160, 140, 40);

    Menu(JFrame frame, JPanel menuPanel) {
        playButton.setPanel(menuPanel);
        infoButton.setPanel(menuPanel);
        exitButton.setPanel(menuPanel);
        this.createMenu(playButton, infoButton, exitButton, frame);
    }

    private void createMenu(MenuButtons start, MenuButtons info, MenuButtons exit, JFrame frame) {
        exit.addActionListener(e -> exitPressed(frame));
        System.out.println("Hello World!");
    }

    public static void exitPressed(JFrame frame) {
        System.out.println("Exit pressed");
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}