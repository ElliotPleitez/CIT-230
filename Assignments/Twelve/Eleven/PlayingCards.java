package Twelve.Eleven;

import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayingCards extends JFrame{

	public static void main(String[] args) {
		PlayingCards playingCards = new PlayingCards();
	}
	
	public PlayingCards(){
		JFrame frame = new JFrame();
		frame.setTitle("Playing Cards");
		frame.setSize(500,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		for (int i = 1; i <= 4; i++){
			panel.add(setButton(new JButton()));
		}

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public JButton setButton(JButton button){
		Random rand = new Random();
		int i = rand.nextInt((54 - 1) + 1) + 1;
		int j = rand.nextInt((1 - 0) + 1) + 0;
		if(j == 0){
			button.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		}
		else{
			button.setIcon(new ImageIcon(getClass().getResource("b2fv.png")));
		}
		button.setPressedIcon(new ImageIcon(getClass().getResource(i + ".png")));
		return button;
	}

}
