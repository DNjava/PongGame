package PongGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball extends Rectangle {
    private int xVelocity;
    private int yVelocity;
    private int initialSpeed = 2;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        xVelocity = initialSpeed;
        yVelocity = initialSpeed;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
        if (y <= 0 || y >= GamePanel.HEIGHT - height) {
            setYDirection(-yVelocity);
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void checkCollision(Paddle leftPaddle, Paddle rightPaddle) {
        if (this.intersects(leftPaddle) || this.intersects(rightPaddle)) {
            setXDirection(-xVelocity);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
}