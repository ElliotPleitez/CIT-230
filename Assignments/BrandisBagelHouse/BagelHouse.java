package BrandisBagelHouse;

//Author: Elliot J Pleitez
//Date: 2014-11-23
//Description: This application allows user to select from options and either calculate total or exit

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BagelHouse extends JFrame implements ActionListener {
    public ButtonGroup bagel = new ButtonGroup(), topping = new ButtonGroup(), coffee = new ButtonGroup();

    public static void main(String[] args) {
        //Setup application
        BagelHouse bagelHouse = new BagelHouse();
        bagelHouse.setTitle("Order Calculator");
        bagelHouse.pack();
        bagelHouse.setLocationRelativeTo(null);
        bagelHouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bagelHouse.setVisible(true);
    }
    
    public BagelHouse(){
        //Setup layout and populate with information
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        panel.add(GreetingsPanel(), BorderLayout.NORTH);
        panel.add(BagelPanel(), BorderLayout.WEST);
        panel.add(ToppingsPanel(), BorderLayout.CENTER);
        panel.add(CoffePanel(), BorderLayout.EAST);
        panel.add(Footer(), BorderLayout.SOUTH);
        
        this.add(panel);
    }
    
    public JPanel GreetingsPanel(){
        //Include label with lettering
        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to Brandi's Bagel House"));
        return panel;
    }
    
    public JPanel BagelPanel(){
        //Include a radio list group with options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Bagel"));
        
        JRadioButton white = new JRadioButton("White");
        white.setActionCommand("1.25");
        JRadioButton wholeWheat = new JRadioButton("Whole Wheat");
        wholeWheat.setActionCommand("1.50");
        
        this.bagel.add(white);
        this.bagel.add(wholeWheat);
        panel.add(white);
        panel.add(wholeWheat);
        return panel;
    }
    
    public JPanel ToppingsPanel(){
        //Include a toggle list group with options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        
        JCheckBox creamCheese = new JCheckBox("Cream Cheese");
        creamCheese.setActionCommand("0.50");
        JCheckBox butter = new JCheckBox("Butter");
        butter.setActionCommand("0.25");
        JCheckBox peachJelly = new JCheckBox("Peach Jelly");
        peachJelly.setActionCommand("0.75");
        JCheckBox blueberryJam = new JCheckBox("Blueberry Jam");
        blueberryJam.setActionCommand("0.75");
        
        this.topping.add(creamCheese);
        this.topping.add(butter);
        this.topping.add(peachJelly);
        this.topping.add(blueberryJam);
        panel.add(creamCheese);
        panel.add(butter);
        panel.add(peachJelly);
        panel.add(blueberryJam);
        return panel;
    }
    
    public JPanel CoffePanel(){
        //Include a radio list group with options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Coffee"));
        
        JRadioButton none = new JRadioButton("None");
        none.setActionCommand("0.00");
        JRadioButton regularCoffee = new JRadioButton("Regular Coffee");
        regularCoffee.setActionCommand("1.25");
        JRadioButton decafCoffee = new JRadioButton("Decaf Coffee");
        decafCoffee.setActionCommand("1.25");
        JRadioButton cappuccino = new JRadioButton("Cappuccino");
        cappuccino.setActionCommand("2.00");
        
        this.coffee.add(none);
        this.coffee.add(regularCoffee);
        this.coffee.add(decafCoffee);
        this.coffee.add(cappuccino);
        panel.add(none);
        panel.add(regularCoffee);
        panel.add(decafCoffee);
        panel.add(cappuccino);        
        return panel;
    }
    
    public JPanel Footer(){
        //Include the calculate and exit buttons with mnemonic characters and action listeners
        JPanel panel = new JPanel();
        
        JButton calculate = new JButton("Calculate");
        JButton exit = new JButton("Exit");
        
        calculate.addActionListener(this);
        calculate.setMnemonic('c');
        exit.addActionListener(this);
        exit.setMnemonic('x');
        
        panel.add(calculate);
        panel.add(exit);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        //when triggered, identify if it was either button and execute code
        if(e.getActionCommand() == "Calculate"){
            double bagel = Double.parseDouble(this.bagel.getSelection().getActionCommand());
            double topping = Double.parseDouble(this.topping.getSelection().getActionCommand());
            double coffee = Double.parseDouble(this.coffee.getSelection().getActionCommand());
            
            double subtotal = bagel + topping + coffee;
            double total = subtotal * 0.06;
            
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Total: " + total);
        }
        else if(e.getActionCommand() == "Exit"){
            System.exit(0);
        }
    }

}
