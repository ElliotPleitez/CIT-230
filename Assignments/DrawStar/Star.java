package DrawStar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Star extends JFrame {

	public static void main(String[] args) {
		Star star = new Star();
		star.setSize(500,250);
		star.setLocationRelativeTo(null);
		star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		star.setBackground(Color.BLUE);
		
		star.setVisible(true);
	}
	
	public Star(){
		this.setTitle("Star");
		this.add(new StarShape());
	}

	class StarShape extends JPanel{
		protected void paintComponent(Graphics g){
			//super.paintComponents(g);
			int xPoints[] = {56, 68, 110, 74, 84, 56, 28, 37, 2, 44};
		    int yPoints[] = {1, 37, 37, 55, 97, 73, 97, 55, 37, 37};
		    
		    Graphics2D g2d = (Graphics2D) g;
		    GeneralPath star = new GeneralPath();
		    
		    star.moveTo(xPoints[0], yPoints[0]);
		    for(int k = 1; k < xPoints.length; k++ ){
		    	star.lineTo(xPoints[k], yPoints[k]);
		    }
		    
		    star.closePath();
		    g2d.setColor(Color.WHITE);
		    g2d.fill(star);

		    g.copyArea(0, 0, 115, 98, 115, 0);
		    g.copyArea(0, 0, 230, 196, 58, 100);
		}
	}

}
