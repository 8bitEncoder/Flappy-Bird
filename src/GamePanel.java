package src;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    //Data members
    private Image bg;

    //Constructor
    public GamePanel() {
        bg = new ImageIcon(getClass().getResource("/assets/img/flappybirdbg.png")).getImage();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
    }
}
