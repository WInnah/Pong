/**
 * Created by Winnah Gwen Acal on 10/22/2016.
 */
import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;
    private static final int LIMIT = 3;
    int x = 100;
    int y = 100;
    int xa = 1;
    int ya = 1;
    private Pong game;

    public Ball(Pong game) {
        this.game = game;
    }

    //this part responsible for the movement of the ball
    void move(){
        boolean changeDirection = true;
        if (game.speed  > LIMIT) {
            game.gameOver();
        }else if (game.speeder > LIMIT){
            game.gameOver();
        }else{
            if (x + xa < 0) {
                xa = game.speed;
            }else if (x + xa > game.getWidth() - DIAMETER){
                xa = -game.speed;
            }else if (y == 0) {
                game.speed++;
                ya = game.speed;
            }else if (y + ya < 0) {
                ya = game.speed;
            }else if (y + ya > game.getHeight() - DIAMETER){
                game.speeder++;
                ya = -game.speed;
            }else if (collision(1)) {
                ya = -game.speed;
            }else if (collision(2)){
                ya = game.speed;
            }else{
                changeDirection = false;
            }
            if (changeDirection)
                Sound.BALL.play();
            x += xa;
            y += ya;
        }
    }

    //this check if the racquet hits the ball
    private boolean collision(int play){
        if (play == 1) {
            return game.racquet.getBounds().intersects(getBounds());
        }else{
            return game.racket.getBounds().intersects(getBounds());
        }
    }
    //this add color to the object created
    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
        g.setColor(Color.PINK);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
