package AmericanFlag;

//http://en.wikipedia.org/wiki/Flag_of_the_United_States
//http://way2java.com/awt-graphics/drawing-polygons-graphics-in-applets/
//http://mathbits.com/MathBits/Java/Graphics/GraphingFill.htm
//http://stackoverflow.com/questions/15620590/polygons-with-double-coordinates
//http://stackoverflow.com/questions/22824454/painting-multiple-objects-in-java


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AmericanFlag extends JFrame {

    public static void main(String[] args) {
        AmericanFlag star = new AmericanFlag();
        star.setTitle("American Flag");
        star.setSize(300,200);
        star.setLocationRelativeTo(null);
        star.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        star.setBackground(new Color(60, 59, 110)); //Blue
//        star.setBackground(new Color(255, 255, 255)); //White
//        star.setBackground(new Color(178, 34, 52)); //Red
        
        star.setVisible(true);
    }

//    ArrayList<MyGeometry> geometry = new ArrayList<MyGeometry>();
//    public enum Shape {
//        Star,
//        Rectangle,
//    }
    
    public AmericanFlag(){
//        this.add(new MyGeometry(Shape.Star))
//        double hoist = 1.0, fly = 1.9;
//        double unionHoist = 7 / 3, unionFly = 0.76;
//        double spacingHoist = 7 / 130, spacingFly = 0.76 / 12;
//        double stripe = 1 / 13;
//        double starDiameter = 0.0616;
    	
    	//JPanel panel = new JPanel();
    	//this.add(new StarShape(){{ x = 0.000; y = 0.000; s = 500; }});
    	this.add(new StarShape());
        //this.add(new StarShape(){{ x = 0.063; y = 0.000; s = 500; }});
        
        //this.add(panel);
    }

//    class MyGeometry{
        class StarShape extends JPanel{
            public double x = 0.000, y = 0.000, s = 250, s1 = 15;
            
            public void paintComponent(Graphics g){
            	myPaint(g, this.x, this.y, this.s);
            }
            
            private void myPaint(Graphics g, double x, double y, double s){
                double xPoints[] = {0.03080000, 0.03771503, 0.06009254, 0.04198875, 0.04890379, 0.03080000, 0.01269621, 0.01961125, 0.00150746, 0.02388497, 0.03080000};
                double yPoints[] = {0.00000000, 0.02128228, 0.02128228, 0.03443545, 0.05571772, 0.04256455, 0.05571772, 0.03443545, 0.02128228, 0.02128228, 0.00000000};
            	
                Graphics2D g2d = (Graphics2D) g;
                Path2D path = new Path2D.Double();
                
            	for(int i = 0; i < 6; i++){
                    path.moveTo(xPoints[0] + i * 100, yPoints[0] + i * 100);
                    for(int j = 0; j < xPoints.length; j++){
                        path.lineTo((xPoints[j] + this.x) * this.s + (i * this.s1), (yPoints[j] + this.y) * this.s);
                    }
                    path.closePath();
                    g2d.setColor(new Color(255, 255, 255));
                    g2d.fill(path);
            	}
            	
            }
        }
        
        class RectangleShape extends JPanel{
            public double x = 0.000, y = 15.000, s = 250, s1 = 20;
            
            public void paintComponent(Graphics g){
            	myPaint(g, this.x, this.y, this.s);
            }
            
            private void myPaint(Graphics g, double x, double y, double s){
                double xPoints[] = {0.03080000, 0.03771503, 0.06009254, 0.04198875, 0.04890379, 0.03080000, 0.01269621, 0.01961125, 0.00150746, 0.02388497, 0.03080000};
                double yPoints[] = {0.00000000, 0.02128228, 0.02128228, 0.03443545, 0.05571772, 0.04256455, 0.05571772, 0.03443545, 0.02128228, 0.02128228, 0.00000000};
            	
                Graphics2D g2d = (Graphics2D) g;
                Path2D path = new Path2D.Double();
                
            	for(int i = 0; i < 6; i++){
                    path.moveTo(xPoints[0] + i * 100, yPoints[0] + i * 100);
                    for(int j = 0; j < xPoints.length; j++){
                        path.lineTo((xPoints[j] + this.x) * this.s + (i * this.s1), (yPoints[j] + this.y) * this.s);
                    }
                    path.closePath();
                    g2d.setColor(new Color(255, 255, 255));
                    g2d.fill(path);
            	}
            	
            }
        }
//    }
    
}
