package PongGame;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private final int PADDLE_WIDTH = 10;
    private final int PADDLE_HEIGHT = 100;
    private final int BALL_SIZE = 20;

    private Paddle leftPaddle, rightPaddle;
    private Ball ball;
    private Timer timer;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyHandler());

        leftPaddle = new Paddle(10, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, KeyEvent.VK_W, KeyEvent.VK_S);
        rightPaddle = new Paddle(WIDTH - 20, HEIGHT / 2 - PADDLE_HEIGHT / 2, PADDLE_WIDTH, PADDLE_HEIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        ball = new Ball(WIDTH / 2 - BALL_SIZE / 2, HEIGHT / 2 - BALL_SIZE / 2, BALL_SIZE, BALL_SIZE);

        timer = new Timer(1000 / 60, this);
    }

    public void startGame() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftPaddle.draw(g);
        rightPaddle.draw(g);
        ball.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftPaddle.move();
        rightPaddle.move();
        ball.move();
        ball.checkCollision(leftPaddle, rightPaddle);
        repaint();
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            leftPaddle.keyPressed(e);
            rightPaddle.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            leftPaddle.keyReleased(e);
            rightPaddle.keyReleased(e);
        }
    }
}