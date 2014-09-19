package Ten.Thirteen;

import Ten.Four.MyPoint;

//Author: Elliot J Pleitez, Luisito Espanola
//Date: 2014-09-16
//Description: This is a rectangle class, it has a default size, or variable size. It has the ability to calculate it's area, perimeter and whether a point or line is within or crosses itself
//Notes: 

public class MyRectangle2D {
	//Fields/Properties
	private double x, y, length, width;
	private MyPoint p1, p2, p3, p4;
	
	//Constructors
	public MyRectangle2D(){
		this.p1 = new MyPoint(0, 0);
		this.p2 = new MyPoint(0, 1);
		this.p3 = new MyPoint(1, 1);
		this.p4 = new MyPoint(1, 0);
		this.x = 0;
		this.y = 0;
		this.length = 1;
		this.width = 1;
	}
	
	public MyRectangle2D(double x, double y, double length, double width){
		this.p1 = new MyPoint(x, y);
		this.p2 = new MyPoint(x, y + width);
		this.p3 = new MyPoint(x + length, y + width);
		this.p4 = new MyPoint(x + length, y);
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
	}
	
	//Accessor methods (Set & Get)
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void setX(double x){
		this.p1.setX(x);
		this.p2.setX(x);
		this.p3.setX(x + this.length);
		this.p4.setX(x + this.length);
		this.x = x;
	}
	
	public void setY(double y){
		this.p1.setY(y);
		this.p2.setY(y + this.y);
		this.p3.setY(y + this.width);
		this.p4.setY(y);
		this.y = y;
	}
	
	public double getLength(){
		return this.length;
	}
	
	public void setLength(double length){
		this.p3.setX(this.x + length);
		this.p4.setX(this.x + length);
		this.length = length;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public void setWidth(double width){
		this.p2.setY(this.y + width);
		this.p3.setY(this.y + width);
		this.width = width;
	}
	
	public double getArea(){
		return this.calculateRectangleArea(this.x, this.y, this.length, this.width);
	}
	
	public double getPerimeter(){
		//Perimeter of a rectangle: p = 2 * (l + w)
		return Math.abs(2 * ((this.x - this.length) + (this.y - this.width)));
	}
	
	//Action methods	
	public boolean contains(double x, double y){
		return this.calculateRectangleContains(x, y);
	}
	
	public boolean contains(MyPoint p){
		return this.calculateTriangleContains(p);
	}
	
	public boolean contains(MyRectangle2D r){
		//if(this.contains(r.x, r.y) && this.contains(r.x, r.y + r.width) && this.contains(r.x + r.length, r.y + r.width) && this.contains(r.x + r.length, r.y)){
		if(this.contains(r.x, r.y) && this.contains(r.x, r.y + r.width) && this.contains(r.x + r.length, r.y + r.width) && this.contains(r.x + r.length, r.y)){
			return true; //All points are within this
		}
		else{
			return false; //One point is not within this
		}
	}
	
	public boolean overlaps(MyRectangle2D r){
		//Triangle overlaps: Ax+By=C
		Line[] rectangle1 = {
				new Line(this.x, this.y, this.x, this.y + this.width),
				new Line(this.x, this.y + this.width, this.x + this.length, this.y + this.width),
				new Line(this.x + this.length, this.y + this.width, this.x + this.length, this.y),
				new Line(this.x + this.length, this.y, this.x, this.y)
		};
		Line[] rectangle2 = {
				new Line(r.x, r.y, r.x, r.y + r.width),
				new Line(r.x, r.y + r.width, r.x + r.length, r.y + r.width),
				new Line(r.x + r.length, r.y + r.width, r.x + r.length, r.y),
				new Line(r.x + r.length, r.y, r.x, r.y)
		};
		
		//For every line within rectangle 1 compare with every line of rectangle 2
		for(int i=0; i < rectangle1.length; i++){
			for(int j=0; j < rectangle2.length; j++){
				double ratio = rectangle1[i].getA() * rectangle2[j].getB() - rectangle2[j].getA() * rectangle1[i].getB();
				double x = (rectangle2[j].getB() * rectangle1[i].getC() - rectangle1[i].getB() * rectangle2[j].getC()) / ratio;
				double y = (rectangle1[i].getA() * rectangle2[j].getC() - rectangle2[j].getA() * rectangle1[i].getC()) / ratio;
				
				if(Math.min(rectangle1[i].get1X(), rectangle2[j].get2X()) < x && Math.max(rectangle1[i].get1X(), rectangle2[j].get2X()) < x){
					if(Math.min(rectangle1[i].get1Y(), rectangle2[j].get2Y()) < y && Math.max(rectangle1[i].get1Y(), rectangle2[j].get2Y()) < y){
						return true; //line segment crosses rectangle
					}
				}
			}
		}
		return false;
	}
	
	private double calculateRectangleArea(double x, double y, double length, double width){
		//Create an array and cross multiply, subtracting then dividing by two to get area
		//Make so it can grow for polylines grater than four
		double a, b;
		a = (x * (y + width)) + (x * (y + width)) + ((x + length) * y) + ((x + length) * y);
		b = (y * x) + ((y + width) * (x + length)) + ((y + width) * (x + length) + (y * x));
		return Math.abs((a - b) / 2);
	}
	
	private double calculateTriangleArea(MyPoint p1, MyPoint p2, MyPoint p3){
		//Area of a triangle: a = (h * b) / 2
		//Area of a triangle: [X1(Y2 - Y3) + X2(Y3 - Y1) + X3(Y1 - Y2)] / 2
		//Legend: h=height, b=base
		return Math.abs((p1.getX() * ((p2.getY() - p3.getY())) + p2.getX() * ((p3.getY() - p1.getY())) + p3.getX() * (p1.getY() - p2.getY())) / 2);
	}
	
	private boolean calculateRectangleContains(double x, double y){
		//Point lie within: if area between r and alternating points around rectangle equal to area of rectangle then r must lie within rectangle
		//Note: if point lies on line then it does NOT return true
		double tempArea1, tempArea2, tempArea3, tempArea4;
		tempArea1 = this.calculateRectangleArea(this.x, this.y, x, y);
		tempArea2 = this.calculateRectangleArea(this.x, (this.y + this.width) - y, x, this.width - y);
		tempArea3 = this.calculateRectangleArea((this.x + this.length) - x, (this.width - y) - y, (this.x + this.length) - x, (this.y + this.width) - x);
		tempArea4 = this.calculateRectangleArea((this.x + this.length) - x, y, (this.x + this.length) - x,y - this.y);
		
		if(tempArea1 + tempArea2 + tempArea3 + tempArea4 == this.getArea()){
			return true; //x,y lies within this
		}
		else{
			return false; //x,y does not lie within this
		}
	}
	
	private boolean calculateTriangleContains(MyPoint p){
		//Point lie within: if area between p and alternating points around triangle equal to area of triangle then p must lie within triangle
		//Note: if point lies on line then it does NOT return true
		double tempArea1, tempArea2, tempArea3, tempArea4;
		tempArea1 = this.calculateTriangleArea(this.p1, this.p2, p);
		tempArea2 = this.calculateTriangleArea(this.p2, this.p3, p);
		tempArea3 = this.calculateTriangleArea(this.p3, this.p4, p);
		tempArea4 = this.calculateTriangleArea(this.p4, this.p1, p);
		
		if(tempArea1 + tempArea2 + tempArea3 + tempArea4 == this.getArea()){
			return true; //p lies within this
		}
		else{
			return false; //p does not lie within this
		}
	}
	
	//Create a Geometry class to place this in for future use
		private class Line {
			//Fields/Properties
			private double p1x, p1y, p2x, p2y;
			private double A, B, C;
			
			//Constructors
			public Line(double p1x,double p1y,double p2x,double p2y){
				this.p1x = p1x;
				this.p1y = p1y;
				this.p2x = p2x;
				this.p2y = p2y;
				
				this.A = p2y - p1y;
				this.B = p1x - p2x;
				this.C = this.A * p1x + this.B * p1y;
			}
			
			//Accessor methods (Get & Set)
			public double getA(){
				return this.A;
			}
			public double getB(){
				return this.B;
			}
			public double getC(){
				return this.C;
			}
			public double get1X(){
				return this.p1x;
			}
			public double get1Y(){
				return this.p1y;
			}
			public double get2X(){
				return this.p2x;
			}
			public double get2Y(){
				return this.p2y;
			}
			
			//Action methods
		}
	
}
