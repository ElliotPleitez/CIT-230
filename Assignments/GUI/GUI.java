package GUI;

import javax.swing.JFrame;

public class GUI {
    public static void main(String[] args) {
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.add(new MyPanel());
		f.pack();
		f.setVisible(true);
	}
}