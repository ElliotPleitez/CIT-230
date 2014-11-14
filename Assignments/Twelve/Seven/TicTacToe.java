package Twelve.Seven;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {
	public static void main(String[] args) {
		TicTacToe ttt = new TicTacToe();
	}

	public TicTacToe(){
		JFrame frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe");
		frame.setSize(500,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		for (int i = 1; i <= 9; i++){
			panel.add(new JLabel(setImage()));
		}

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public ImageIcon setImage(){
		Random rand = new Random();
		int i = rand.nextInt((1 - 0) + 1) + 0;
		if(i == 0){
			return new ImageIcon(getClass().getResource("o.gif"));			
		}
		else{
			return new ImageIcon(getClass().getResource("x.gif"));
		}
	}
}
