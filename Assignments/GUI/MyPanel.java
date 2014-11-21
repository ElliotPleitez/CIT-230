package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	ArrayList <body> system = new ArrayList<body>();
	public MyPanel() {
	    add(new body(1000,20,Color.yellow,0,0,100,100));
	    add(new body(10,5,Color.black,5,0,100,50));
	}

	public void add(body b){system.add(b);}

	public Dimension getPreferredSize() {
	    return new Dimension(600,600);
	}

	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	
	    for (body b: system) {
	        Ellipse2D object = new Ellipse2D.Double();
	        object.setFrameFromCenter(
	            b.getposx() - b.getSize(),
	            b.getposy() - b.getSize(),
	            b.getposx(),
	            b.getposy());
	        g2.setColor(b.getColor());
	        g2.fill(object);
	    }
	}  
}