/**
 * Created by Winnah Gwen Acal on 10/22/2016.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Pong extends JPanel{

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this, 330, 60, 10);
    Racquet racket = new Racquet(this, 20, 60, 10);

    int speed = 1;
    int speeder = 1;

    //determines the of player 1
    private int getScorePlayer1(){
        return speed - 1;
    }

    //determines the score for player 2
    private int getScorePlayer2(){
        return speeder - 1;
    }

    public Pong(){
        //these are key listener. Its role is to listen and to interpret the keys given by the user
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e, 1);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
        });
        setFocusable(true);
        Sound.BACK.loop();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racket.keyPressed(e, 2);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racket.keyReleased(e);
            }
        });
        setFocusable(true);
        Sound.BACK.loop();

    }

    //this calls all the move method of every sprite
    private void move(){
        ball.move();
        racquet.move();
        racket.move();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g); //for repainting so it wouldn't look like a connected circle
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); //for smoother border
        ball.paint(g2d);
        racquet.paint(g2d);
        racket.paint(g2d);

        //this is for the score visible in the corner
        //Racket top
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScorePlayer2()), 10, 50);
        //Racquet bottom
        g2d.setColor(Color.green);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScorePlayer1()), 250, 300);
    }
    //if the game is over this method is called and dialog appear to ask if the players wanted to continue the game
    public void gameOver(){
        Sound.BACK.stop();
        Sound.GAMEOVER.play();
        JDialog.setDefaultLookAndFeelDecorated(true);
        if (speed > 3 || speeder > 3) {
            int response = JOptionPane.showConfirmDialog(null, "\tGAME OVER!\nPlayer 1 Score is: " + getScorePlayer1() + "\nPlayer 2 Score is: " + getScorePlayer2() +
                            "\nDo you want to play again?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (response == JOptionPane.YES_OPTION) {
                main(null);
            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        //this creates a new frame given the size.
        JFrame frame = new JFrame("Mini Tennis");
        Pong game = new Pong();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this is responsible for the one visible in the screen
        while (true){
            game.move();
            game.repaint();
            //this part is responsible for the motion seen
            //without this part the movement of the ball will be so fast
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {

            }
        }
    }
}
