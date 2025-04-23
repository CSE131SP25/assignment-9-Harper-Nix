package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
    
    private Snake snake;
    private Food food;
    private int score = 0;

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
    }

    public void play() {
        while (snake.isInbounds()) {
            int dir = getKeypress();

            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            if (snake.eatsFood(food)) {
                food = new Food(); // Respawn new food
                score++;
            }

            updateDrawing();
        }

        // Game Over Message
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0.5, 0.5, "Game Over! Final Score: " + score);
        StdDraw.show();
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            return 1; // Up
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            return 2; // Down
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            return 3; // Left
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            return 4; // Right
        } else {
            return -1; // No input
        }
    }

    /**
     * Clears the screen, draws the snake and food, displays score, and updates the screen.
     */
    private void updateDrawing() {
        StdDraw.clear();

        snake.draw();
        food.draw();

        // Draw score
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.9, 0.95, "Score: " + score);

        StdDraw.pause(50); // Delay for smoother animation
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
