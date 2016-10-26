import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Winnah Gwen Acal on 10/22/2016.
 */

public class Racquet {
    //declaration of the constant
    private int Y;
    private int WIDTH;
    private int HEIGHT;
    int x = 0;
    int xa = 0;
    private Pong game;

    public Racquet(Pong game, int Y, int WIDTH, int HEIGHT) {
        this.Y = Y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.game = game;
    }

    //this indicates the movement of the racquet
    public void move(){
        if (x + xa > 0 && x + xa < game.getWidth()-WIDTH)
            x = x + xa;
    }

    //responsible for the display seen on screen
    public void paint(Graphics2D g){
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }


    public void keyReleased(KeyEvent e){
        xa = 0;
    }

    //this part is the control for the movement of the racquet
    public void keyPressed(KeyEvent e, int control) {
        if (control == 1){
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                xa = -game.speed;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                xa = game.speed;
        }else{
            if (e.getKeyCode() == KeyEvent.VK_A)
                xa = -game.speed;
            if (e.getKeyCode() == KeyEvent.VK_D)
                xa = game.speed;
        }

    }
    //check the boundary of the object
    public Rectangle getBounds(){
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }


}
