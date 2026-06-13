package src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    //Data members
    private Image bg;
    private Bird bird;
    private Timer timer;

    //Constructor
    public GamePanel() {
        bg = new ImageIcon(getClass().getResource("/assets/img/flappybirdbg.png")).getImage();
        bird = new Bird(new ImageIcon(getClass().getResource("/assets/img/flappybird.png")).getImage());
        timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
        bird.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.update();
        repaint();
    }
}                       