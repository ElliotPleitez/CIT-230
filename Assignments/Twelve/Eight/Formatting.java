package Twelve.Eight;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Formatting extends JFrame{

	public static void main(String[] args) {
		Formatting formatting = new Formatting();
	}

	public Formatting(){
		JFrame frame = new JFrame();
		frame.setTitle("Formatting");
		frame.setSize(500,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		for (int i = 1; i <= 6; i++){
			JLabel label = new JLabel();
			switch(i){
			case 1:
				setProperties(label, "black", Color.BLACK);
				break;
			case 2:
				setProperties(label, "blue", Color.BLUE);
				break;
			case 3:
				setProperties(label, "cyan", Color.CYAN);
				break;
			case 4:
				setProperties(label, "green", Color.GREEN);
				break;
			case 5:
				setProperties(label, "magenta", Color.MAGENTA);
				break;
			case 6:
				setProperties(label, "orange", Color.ORANGE);
				break;
			}
			panel.add(label);
		}

		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void setProperties(JLabel label, String stringColor, Color color){
		label.setBackground(Color.WHITE);
		label.setBorder(new LineBorder(Color.YELLOW));
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setText(stringColor);
		label.setToolTipText(stringColor);
		label.setForeground(color);
	}

}
