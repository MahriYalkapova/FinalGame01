import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

public class Listener implements KeyListener {

    JFrame frame;
    Pane primary;

    //The no-arg was mainly for testing, but it creates a JFrame to use the rest of the code.
    public Listener() {
        frame = new JFrame("Game");
        primary = new Pane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(primary);
        frame.pack();
        frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
        frame.addKeyListener(this);
    }
    public Listener(JFrame frame, Pane primary) {
        this.frame=frame;
        this.primary=primary;
        this.frame.addKeyListener(this);
    }

    //This part is where the commands are put for what happens when pressed.
    //For testing, it currently prints out what button is pressed and changes the background color between black and white
    
    @Override public void keyPressed(KeyEvent e) {
        //Insert actions to perform here whenever a key is pressed
        //If we only want specific keys to work, we can use an if condition here
        primary.reset();
    }
    @Override public void keyTyped(KeyEvent e) {} 
    @Override public void keyReleased(KeyEvent e) {
        //Insert an action here for when the key is released
    }
}