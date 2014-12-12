package Final;

//Author: Elliot J Pleitez
//Date: 2014-11-13 -- Revised for final on 2014-12-11
//Description: This is a GUI application that formats several labels with different properties

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Formatting extends JFrame{
	//main stub for application
	public static void main(String[] args) {
		Formatting formatting = new Formatting();
	}

	public Formatting(){
		//create the frame and it's properties
		JFrame frame = new JFrame();
		frame.setTitle("Formatting");
		frame.setSize(500,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//create panel and layout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 3));
		//for each item create a label
		for (int i = 1; i <= 6; i++){
			//for each instance create a unique label by calling method
			JLabel label = new JLabel();
			switch(i){
				case 1:
					this.setProperties(label, "black", Color.BLACK);
					break;
				case 2:
					this.setProperties(label, "blue", Color.BLUE);
					break;
				case 3:
					this.setProperties(label, "cyan", Color.CYAN);
					break;
				case 4:
					this.setProperties(label, "green", Color.GREEN);
					break;
				case 5:
					this.setProperties(label, "magenta", Color.MAGENTA);
					break;
				case 6:
					this.setProperties(label, "orange", Color.ORANGE);
					break;
			}
			//then add to panel
			panel.add(label);
		}

		//add panel to frame and display frame
		frame.add(panel);
		frame.setVisible(true);
	}

	//set properties of label as define in arguments
	public void setProperties(JLabel label, String stringColor, Color color){
		label.setBackground(Color.WHITE);
		label.setForeground(color);
		label.setBorder(new LineBorder(Color.YELLOW));
		label.setText(stringColor);
		label.setToolTipText(stringColor);
		label.setFont(new Font("TimesNewRoman", 1, 20));
	}

}