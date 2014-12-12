package Final;

//Author: Elliot J Pleitez
//Date: 2014-12-11
//Description: This application collects input that calculates future investment with a given interest rate

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFinal {
	//Fields for class
	JTextField investmentInput = new JTextField();
	JTextField yearInput = new JTextField();
	JTextField interestInput = new JTextField();
	JTextField futureField = new JTextField();
	JButton button = new JButton("Calculate");

	public static void main(String[] args) {
		MyFinal finalExam = new MyFinal();
	}
	
	public MyFinal() {
		//create the frame and it's properties
		JFrame frame = new JFrame();
		frame.setTitle("My Investment Calculator");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create panel and add components
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		panel.add(new JLabel("Enter investment value:"));
		panel.add(this.investmentInput);

		panel.add(new JLabel("Enter year value:"));
		panel.add(this.yearInput);

		panel.add(new JLabel("Enter interest value:"));
		panel.add(this.interestInput);

		panel.add(new JLabel("Future amount:"));
		futureField.setEditable(false);
		panel.add(this.futureField);
		
		//add a new listener to button and calculate based on input
		this.button.addActionListener(new CalculateListener());
		panel.add(this.button);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		
		//add panel to frame and display frame
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//custom action listener
	public class CalculateListener implements ActionListener{
		//when performed calculate investment amount
		public void actionPerformed(ActionEvent e) {
			Double investment = Double.parseDouble(investmentInput.getText());
			int year = Integer.parseInt(yearInput.getText());
			double interest = Double.parseDouble(interestInput.getText());
			
			futureField.setText(String.format("%.2f", investment * Math.pow((1 + (interest / 12)), year * 12)));
		}
	}
}
