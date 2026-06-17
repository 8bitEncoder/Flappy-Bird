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
    private Pipe[] pipes = new Pipe[6];
    private Timer timer;

    //Constructor
    public GamePanel() {
    
        bg = new ImageIcon(getClass().getResource("/src/assets/img/flappybirdbg.png")).getImage();
        bird = new Bird(new ImageIcon(getClass().getResource("/src/assets/img/flappybird.png")).getImage());

        for (int i = 0; i < 6; i += 2) {
            int pipeX = 400 + (i / 2) * 300;
            
            pipes[i] = new Pipe(new ImageIcon(getClass().getResource("/src/assets/img/toppipe.png")).getImage(), pipeX, 0);
            pipes[i + 1] = new Pipe(new ImageIcon(getClass().getResource("/src/assets/img/bottompipe.png")).getImage(), pipeX, 340);
        }
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(16, e -> {
            bird.update();
            for (Pipe pipe : pipes) {
                pipe.move();
                if (pipe.isOffScreen()) {
                    pipe.reset(800);
                }
            }
            repaint();
        }); // ~60 FPS
        timer.start();
        
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
        for (Pipe pipe : pipes) {
            pipe.draw(g);
        }
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