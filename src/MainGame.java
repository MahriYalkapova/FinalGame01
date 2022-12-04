import java.awt.*;
import javax.swing.*;


public class MainGame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Circleworks");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pane primary = new Pane();
     	frame.add(primary);
     	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
	}
}