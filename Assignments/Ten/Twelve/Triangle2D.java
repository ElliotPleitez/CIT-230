package Ten.Twelve;
import Ten.Four.MyPoint;

//Add area to field/properties so calculateArea() does not need to be executed so many times

public class Triangle2D {
	//Fields/Properties
	private MyPoint p1, p2, p3; //where p1 is lower left, p2 is top center, p3 is lower right
	
	//Constructors
	public Triangle2D(){
		p1 = new MyPoint(0, 0);
		p2 = new MyPoint(1, 1);
		p3 = new MyPoint(2, 5);
	}
	public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3){
		p1 = new MyPoint(x1, y1);
		p2 = new MyPoint(x2, y2);
		p3 = new MyPoint(x3, y3);
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
	
	//Action methods
	public double getArea(){
		return this.calculateArea(this.p1, this.p2, this.p3);
	}
	public double getPerimeter(){
		//Perimeter of a triangle: p = a + b + c
		double perimeter = this.p1.getDistance(this.p2) + this.p2.getDistance(this.p3) + this.p3.getDistance(this.p1);
		return perimeter;
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
		Object[] triangle1 = {
				new Line(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY()),
				new Line(this.p2.getX(), this.p2.getY(), this.p3.getX(), this.p3.getY()),
				new Line(this.p3.getX(), this.p3.getY(), this.p1.getX(), this.p1.getY())
		};
		Object[] triangle2 = {
				new Line(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY()),
				new Line(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY()),
				new Line(t.p3.getX(), t.p3.getY(), t.p1.getX(), t.p1.getY())
		};
		
		//compare each line with another
		return false;
	}
	
	//Create a Geometry class to place this in for future use
	private class Line {
		//Fields/Properties
		private double p1x, p1y, p2x, p2y;
		private double A, B, C;
		
		//Constructors
		public Line(double p1x,double p1y,double p2x,double p2y){
			this.A = this.p2y - this.p1y;
			this.B = this.p1x - this.p2x;
			this.C = this.A * this.p1x + this.B * this.p1y;
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
		
		//Action methods
	}
	
	private double calculateArea(MyPoint p1, MyPoint p2, MyPoint p3){
		//Area of a triangle: a = (h * b) / 2
		//Area of a triangle: [X1(Y2 - Y3) + X2(Y3 - Y1) + X3(Y1 - Y2)] / 2
		//Legend: h=height, b=base
		double area = (p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY()) + p3.getX() * (p1.getY() - p2.getY())) / 2;
		return area;
	}
	private boolean calculateContains(MyPoint p){
		//Point lie within: if area between p and alternating points around triangle equal to area of triangle then p must lie within triangle		
		double tempArea1, tempArea2, tempArea3;
		tempArea1 = this.calculateArea(p, this.p1, this.p2);
		tempArea2 = this.calculateArea(p, this.p2, this.p3);
		tempArea3 = this.calculateArea(p, this.p3, this.p1);
		
		if(tempArea1 + tempArea2 + tempArea3 == this.calculateArea(this.p1, this.p2, this.p3)){
			return true; //p lies within this
		}
		else{
			return false; //p does not lie within this
		}
	}
	
}
