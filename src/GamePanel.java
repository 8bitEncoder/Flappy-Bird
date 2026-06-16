package src;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
    //Data members
    private Image bg;
    private Bird bird;
    private Pipe pipe;
    private Timer timer;

    //Constructor
    public GamePanel() {
        
        bg = new ImageIcon(getClass().getResource("/src/assets/img/flappybirdbg.png")).getImage();
        bird = new Bird(new ImageIcon(getClass().getResource("/src/assets/img/flappybird.png")).getImage());
        pipe = new Pipe(new ImageIcon(getClass().getResource("/src/assets/img/bottompipe.png")).getImage());
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(16, e -> {
            bird.update();
            pipe.move();
            if (pipe.isOffScreen()) {
                System.out.println("pipe is off screen");
                pipe.reset();
            }
            repaint();
        }); // ~60 FPS
        timer.start();
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
        pipe.draw(g);
        bird.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}                       