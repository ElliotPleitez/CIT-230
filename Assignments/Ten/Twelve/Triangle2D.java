package Ten.Twelve;
import Ten.Four.MyPoint;

//Author: Elliot J Pleitez, Luisito Espanola
//Date: 2014-09-16
//Description: This is a triangle class, it has a default size, or variable size. It has the ability to calculate it's area, perimeter and whether a point or line is within or crosses itself
//Note: Add area to field/properties so calculateArea() does not need to be executed so many times

public class Triangle2D {
	//Fields/Properties
	private MyPoint p1, p2, p3; //where p1 is lower left, p2 is top center, p3 is lower right
	
	//Constructors
	public Triangle2D(){
		this.p1 = new MyPoint(0, 0);
		this.p2 = new MyPoint(1, 1);
		this.p3 = new MyPoint(2, 5);
	}
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	//Accessor methods (Set & Get)
	public MyPoint getP1(){
		return this.p1;
	}
	public MyPoint getP2(){
		return this.p2;
	}
	public MyPoint getP3(){
		return this.p3;
	}
	public void setP1(double newX, double newY){
		this.p1.setX(newX);
		this.p1.setY(newY);
	}
	public void setP2(double newX, double newY){
		this.p2.setX(newX);
		this.p2.setY(newY);
	}
	public void setP3(double newX, double newY){
		this.p3.setX(newX);
		this.p3.setY(newY);
	}
	
	public double getArea(){
		return this.calculateArea(this.p1, this.p2, this.p3);
	}
	public double getPerimeter(){
		//Perimeter of a triangle: p = a + b + c
		return this.p1.getDistance(this.p2) + this.p2.getDistance(this.p3) + this.p3.getDistance(this.p1);
	}
	public boolean contains(MyPoint p){
		return this.calculateContains(p);
	}
	public boolean contains(Triangle2D t){
		//Triangle lie within: if all point lie within triangle then triangle must lie within triangle
		if(this.contains(t.p1) && this.contains(t.p2) && this.contains(t.p3) == true){
			return true; //t lies within this
		}
		else{
			return false; //t does not lie within this
		}
	}
	public boolean overlaps(Triangle2D t){
		//Triangle overlaps: Ax+By=C
		Line[] triangle1 = {
				new Line(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY()),
				new Line(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY()),
				new Line(this.p3.getX(), this.p3.getY(), this.p1.getX(), this.p1.getY())
		};
		Line[] triangle2 = {
				new Line(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY()),
				new Line(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY()),
				new Line(t.p3.getX(), t.p3.getY(), t.p1.getX(), t.p1.getY())
		};

		//For every line within triangle 1 compare with every line of triangle 2
		for(int i=0; i < triangle1.length; i++){
			for(int j=0; j < triangle2.length; j++){
				double ratio = triangle1[i].getA() * triangle2[j].getB() - triangle2[j].getA() * triangle1[i].getB();
				double x = (triangle2[j].getB() * triangle1[i].getC() - triangle1[i].getB() * triangle2[j].getC()) / ratio;
				double y = (triangle1[i].getA() * triangle2[j].getC() - triangle2[j].getA() * triangle1[i].getC()) / ratio;
				
				if(Math.min(triangle1[i].get1X(), triangle2[j].get2X()) < x && Math.max(triangle1[i].get1X(), triangle2[j].get2X()) < x){
					if(Math.min(triangle1[i].get1Y(), triangle2[j].get2Y()) < y && Math.max(triangle1[i].get1Y(), triangle2[j].get2Y()) < y){
						return true; //line segment crosses triangle
					}
				}
				//Note: Debug
				//System.out.println("Triangle 1, Line " + i + " X: " + x);
				//System.out.println("Triangle 2, Line " + j + " Y: " + y);
			}
		}
		return false;
	}
	
	private double calculateArea(MyPoint p1, MyPoint p2, MyPoint p3){
		//Area of a triangle: a = (h * b) / 2
		//Area of a triangle: [X1(Y2 - Y3) + X2(Y3 - Y1) + X3(Y1 - Y2)] / 2
		//Legend: h=height, b=base
		return Math.abs((p1.getX() * ((p2.getY() - p3.getY())) + p2.getX() * ((p3.getY() - p1.getY())) + p3.getX() * (p1.getY() - p2.getY())) / 2);
	}
	private boolean calculateContains(MyPoint p){
		//Point lie within: if area between p and alternating points around triangle equal to area of triangle then p must lie within triangle
		//Note: if point lies on line then it does NOT return true
		double tempArea1, tempArea2, tempArea3;
		tempArea1 = this.calculateArea(this.p1, this.p2, p);
		tempArea2 = this.calculateArea(p, this.p2, this.p3);
		tempArea3 = this.calculateArea(this.p1, p, this.p3);
		
		if(tempArea1 + tempArea2 + tempArea3 == this.getArea()){
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
