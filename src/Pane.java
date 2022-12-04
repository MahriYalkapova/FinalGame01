import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.lang.Math;

public class Pane extends JPanel {
	// lets initiate a few variables to keep track of position, as well as a random speed variable
	private int x = 0;
	private int y = 0;
	private int height = 1000;
    private int width = 1000;
    private int speed = (int)(Math.random() * 10) + 1;

    public Pane() {
    	// Here when we create a Pane object it creates a timer and starts it.
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// First we check if the circle is done shrinking, and if so reset it, otherwise we just shrink and repaint
            	if (height <= 0)
            		reset();
            	shrink();
                repaint();
             }
         });
        timer.start();
         
     }

    protected void shrink() {
    	// We need the speed variable to be even so we can cleanly divide by two to keep the circle in the center, so we make sure it's even here
    	if (speed % 2 != 0) {
    		speed = speed + 1;
    	}
    	x += speed / 2;
    	y += speed / 2;
        height -= speed;
        width -= speed;
     }
     @Override
     public Dimension getPreferredSize() {
         return new Dimension(1000, 1000);
     }
     // Now we make a new paint component
     protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2d = (Graphics2D) g.create();
         g2d.setColor(Color.RED);
         // We need to set the stroke here to make it thicker so it looks better
         g2d.setStroke(new BasicStroke(15));
         g2d.drawOval(x, y, width, height);
         // We also need to draw two helper ovals
         g2d.setStroke(new BasicStroke(3));
         g2d.drawOval(300, 300, 400, 400);
         g2d.drawOval(280, 280, 440, 440);
         g2d.dispose();
     }
     public void reset() {
    	 // If it isn't done shrinking, we instantly return, stopping the function, otherwise we restart the circle with a different speed
    	 height = 1000;
    	 width = 1000;
    	 x = 0;
    	 y = 0;
    	 speed = (int)(Math.random() * 10) + 1;
     }
 }