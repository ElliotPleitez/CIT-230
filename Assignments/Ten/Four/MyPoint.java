package Ten.Four;

//Author: Elliot J Pleitez, Luisito Espanola
//Date: 2014-09-07
//Description: This class defines a point. It is self aware of it's coordinates and can calculate the distance between it and another point.
//				This class can change it's point.

public class MyPoint {
	//Fields/Properties
	private double x, y;
	
	//Constructors
	public MyPoint(){
		this.x = 0.0;
		this.y = 0.0;
	}
	public MyPoint(double newX, double newY){
		this.x = newX;
		this.y = newY;
	}
	
	//Accessor methods (Set & Get)
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public void setX(double newX){
		this.x = newX;
	}
	public void setY(double newY){
		this.y = newY;
	}
	//Action methods
	public double getDistance(MyPoint otherPoint){
		//Distance formula: d = sqrt(square(X2-X1) + square(Y2-Y1))
		double distance = Math.sqrt(Math.pow(otherPoint.x, this.x) + Math.pow(otherPoint.y, this.y));
		return distance;
	}
	
}
