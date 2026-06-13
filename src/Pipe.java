package src;

import java.awt.Graphics;
import java.awt.Image;

public class Pipe {
    //Data members
    
    private static final int WIDTH = 80;
    private static final int HEIGHT = 260;

    // internal state (hidden)
    private int x;
    private int y;

    private Image img;

    public Pipe(Image img) {
        this.img = img;
        // initialization is internal
        this.x = 400;
        this.y = 200;
    }

    public void draw(Graphics g) {
        g.drawImage(img, x, y, WIDTH, HEIGHT, null);
    }

    public void move() {
        x -= 10;
    }

    public boolean isOffScreen() {
        return x + WIDTH < 0;
    }

    public void reset() {
        x = 500;
    }
}
