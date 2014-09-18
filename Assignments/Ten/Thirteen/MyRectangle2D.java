package Ten.Thirteen;

//Author: Elliot J Pleitez, Luisito Espanola
//Date: 2014-09-16
//Description: This is a rectangle class, it has a default size, or variable size. It has the ability to calculate it's area, perimeter and whether a point or line is within or crosses itself
//Notes: 

public class MyRectangle2D {
	//Fields/Properties
	private double x, y, length, width;
	
	//Constructors
	public MyRectangle2D(){
		this.x = 0;
		this.y = 0;
		this.length = 1;
		this.width = 1;
	}
	
	public MyRectangle2D(double x, double y, double length, double width){
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
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public double getLength(){
		return this.length;
	}
	
	public void setLength(double length){
		this.length = length;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getArea(){
		return this.calculateArea(this.x, this.y, this.length, this.width);
	}
	
	public double getPerimeter(){
		//Perimeter of a rectangle: p = 2 * (l + w)
		return Math.abs(2 * ((x - length) + (y - width)));
	}
	
	//Action methods	
	public boolean contains(double x, double y){
		return this.calculateContains(x, y);
	}
	
	public boolean contains(MyRectangle2D r){
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
	
	private double calculateArea(double x, double y, double length, double width){
		//Create an array and cross multiply, subtracting then dividing by two to get area
		//Make so it can grow for polylines grater than four
		double a, b;
		a = (x * (y + width)) + (x * (y + width)) + ((x + length) * y) + ((x + length) * y);
		b = (y * x) + ((y + width) * (x + length)) + ((y + width) * (x + length) + (y * x));
		return Math.abs((a - b) / 2);
	}
	
	private boolean calculateContains(double x, double y){
		//Point lie within: if area between r and alternating points around rectangle equal to area of rectangle then r must lie within rectangle
		//Note: if point lies on line then it does NOT return true
		double tempArea1, tempArea2, tempArea3, tempArea4;
		tempArea1 = this.calculateArea(this.x, this.y, x, y);
		tempArea2 = this.calculateArea(this.x, (this.y + this.width) - y, x, this.width - y);
		tempArea3 = this.calculateArea((this.x + this.length) - x, (this.width - y) - y, (this.x + this.length) - x, (this.y + this.width) - x);
		tempArea4 = this.calculateArea((this.x + this.length) - x, y, (this.x + this.length) - x,y - this.y);
		
		if(tempArea1 + tempArea2 + tempArea3 + tempArea4 == this.getArea()){
			return true; //x,y lies within this
		}
		else{
			return false; //x,y does not lie within this
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
