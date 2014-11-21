package GUI;

import java.awt.Color;

public class body {
	public body(){
	    mass = 100;
	    size = 1;
	    velX = 0;
	    velY = 0;
	    posX = 0;
	    posY = 0;
	    color = Color.white;
	}
	
	public body(int mass, int size, Color color, double velX, double velY, double posX, double posY){
	    body.mass = mass;
	    body.size = size;
	    body.color = color;
	    body.velX = velX;
	    body.velY = velY;
	    body.posX = posX;
	    body.posY = posY;
	
	}
	//Getters
	public int getMass(){return mass;}
	public int getSize(){return size;}
	public double getvelx(){return velX;}
	public double getvely(){return velY;}
	public double getposx(){return posX+velX;}
	public double getposy(){return posY+velY;}
	public Color getColor(){return color;}
	//Setters
	public static void setMass(int m){mass = m;}
	public static void setSize(int s){size = s;}
	public static void setvelx(double v){velX = v;}
	public static void setvely(double v){velY = v;}
	public static void setposx(double p){posX = p;}
	public static void setposy(double p){posY = p;}
	public static void setColor(Color c){color = c;}
	
	//Member Variables
	private static Color color;
	private static int mass;
	private static int size;
	private static double velX;
	private static double velY;
	private static double posX;
	private static double posY;
}