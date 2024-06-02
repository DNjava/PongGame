package PongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    private int id;
    private int yVelocity;
    private int speed = 10;
    private int upKey;
    private int downKey;

    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int upKey, int downKey) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == upKey) {
            setYDirection(-speed);
        }
        if (e.getKeyCode() == downKey) {
            setYDirection(speed);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == upKey || e.getKeyCode() == downKey) {
            setYDirection(0);
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y += yVelocity;
        if (y < 0) {
            y = 0;
        }
        if (y > GamePanel.HEIGHT - height) {
            y = GamePanel.HEIGHT - height;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}