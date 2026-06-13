package src;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(360, 640);
        frame.add(new GamePanel());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
