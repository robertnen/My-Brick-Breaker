import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        System.setProperty("flatlaf.menuBarEmbedded", "false");
        Window window = new Window();


        while(!window.getStatus()) System.out.print(""); // wait for the game to start
        JFrame frame = window.getFrame();
        frame.getContentPane().removeAll();
        frame.repaint();

    }
}
