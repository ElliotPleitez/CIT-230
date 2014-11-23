package AmericanFlag;

//Author: Elliot J Pleitez
//Date: 2014-11-23
//Description: This application simply draws an accurate American flag

//http://en.wikipedia.org/wiki/Flag_of_the_United_States (American flag dimensions)
//http://way2java.com/awt-graphics/drawing-polygons-graphics-in-applets/ (not used because double not supported)
//http://mathbits.com/MathBits/Java/Graphics/GraphingFill.htm (fill g)
//http://stackoverflow.com/questions/15620590/polygons-with-double-coordinates (drawing with double precision)
//http://stackoverflow.com/questions/22824454/painting-multiple-objects-in-java (not used, but considered at one point)

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
        AmericanFlag flag = new AmericanFlag();
        flag.setTitle("American Flag");
        flag.setSize(950, 539); //change to match SIZE
        flag.setLocationRelativeTo(null);
        flag.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flag.setBackground(new Color(255, 255, 255)); //draw background white to make drawing flag easier
        flag.setVisible(true);
    }
    
    public AmericanFlag(){
        this.add(new FlagGeometry()); //begin...
    }

    class FlagGeometry extends JPanel{
        double SIZE = 500; //Pixel height (not accurate, but will determine at later time)
        
        //http://en.wikipedia.org/wiki/File:Flag_of_the_United_States_specification.svg
        double ptA = 1.0 * this.SIZE, ptB = 1.9 * this.SIZE;
        double ptC = ptA * (7.0 / 13.0), ptD = ptB * (2.0 /5.0);
        double ptL = ptA / 13.0;
        double ptE = ptC / 10.0, ptG = ptD / 12.0;
        double ptK = ptL * (4.0 / 5.0);
        double KxPoints[] = {0.03076923, 0.03076923, 0.03767735, 0.06003251, 0.04194681, 0.04885493, 0.03076923, 0.01268353, 0.01959165, 0.00150595, 0.02386111, 0.03076923, 0.03076923};
        double KyPoints[] = {0.03076923, 0.00000000, 0.02126102, 0.02126102, 0.03440105, 0.05566206, 0.04252203, 0.05566206, 0.03440105, 0.02126102, 0.02126102, 0.00000000, 0.03076923};
        Color red = new Color(178, 34, 52);
        Color white = new Color(255, 255, 255);
        Color blue = new Color(60, 59, 110);
        
        public void paintComponent(Graphics g){
            //draw stripes
            Graphics2D stripes = (Graphics2D) g;
            Path2D stripesPath = new Path2D.Double();
            double StripesxPoints[] = {0, this.ptB, this.ptB, 0};
            double StripesyPoints[] = {0, 0, this.ptL, this.ptL};
            for(int i = 0; i < 13; i++){ //for each stripe
                if((i & 1) == 0){ //if stripe count is even then draw red
                    stripesPath.moveTo(0, this.ptL * i);
                    for(int j = 0; j < StripesxPoints.length; j++){
                        stripesPath.lineTo(StripesxPoints[j], StripesyPoints[j] + (this.ptL * i));
                    }
                    stripesPath.closePath();
                    stripes.setColor(this.red);
                    stripes.fill(stripesPath);
                }
            }
            
            //draw canton
            Graphics2D canton = (Graphics2D) g;
            Path2D cantonPath = new Path2D.Double();
            double CantonxPoints[] = {0, this.ptD, this.ptD, 0};
            double CantonyPoints[] = {0, 0, this.ptC, this.ptC};
            cantonPath.moveTo(0, 0);
            for(int i = 0; i < CantonxPoints.length; i++){
                cantonPath.lineTo(CantonxPoints[i], CantonyPoints[i]);
            }
            cantonPath.closePath();
            canton.setColor(this.blue);
            canton.fill(cantonPath);
            
            //draw stars
            Graphics2D stars = (Graphics2D) g;
            Path2D starsPath = new Path2D.Double();
            for(int i = 0; i < 9; i++){ //foreach E row
                for(int j = 0; j < 6; j++){ //foreach G column
                    starsPath.moveTo(this.ptG, this.ptE);
                    for(int k = 0; k < this.KxPoints.length; k++){ //foreach point in star
                        double xCoord = (this.KxPoints[k] * this.SIZE);
                        double yCoord = (this.KyPoints[k] * this.SIZE);
                        if((i & 1) == 0){ //if even
                            starsPath.lineTo(xCoord + (this.ptG * j) * 2 + (this.ptG * 0.5), yCoord + (this.ptE * i) + (this.ptE * 0.5)); //account for offset and double spacing
                        }
                        else{
                            if(j != 5){ //do not draw last star in loop
                                starsPath.lineTo(xCoord + this.ptG + this.ptG * j * 2 + (this.ptG * 0.5), yCoord + (this.ptE * i) + (this.ptE * 0.5)); //account for offset and double spacing
                            }
                        }
                    }
                    starsPath.closePath();
                    stars.setColor(this.white);
                    stars.fill(starsPath);
                }
            }
        }
    }
    
}
