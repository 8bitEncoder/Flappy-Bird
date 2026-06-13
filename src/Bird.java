package src;

import java.awt.Graphics;
import java.awt.Image;

public class Bird {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 35;

    // internal state (hidden)
    private int x;
    private int y;

    private int velocityY = 0;
    private int gravity = 1;

    private Image img;

    public Bird(Image img) {
        this.img = img;
        // initialization is internal
        this.x = 100;
        this.y = 200;
    }

    // ===== BEHAVIOR (public API) =====

    public void update() {
        velocityY += gravity;
        y += velocityY;
    }

    public void jump() {
        velocityY = -10;
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, WIDTH, HEIGHT, null);
    }
}