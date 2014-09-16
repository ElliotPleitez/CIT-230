package Ten.Twelve;
import Ten.Four.*;

/** This creates a program to test Triangle2D class. It creates a triangle with given coordinates, computes
 *  the area, calculates the perimeter and determines whether a given point is contained inside the triangle. 
 *  It also checks whether a given triangle is contained inside the original triangle and another given 
 *  triangle overlaps the original triangle. */

class TestTriangle2D {
	
  public static void main(String[] args) {
	  
    Triangle2D t = new Triangle2D(); // Creates an instance t of Triangle2D a no-arg constructor.
    
    // Display coordinates of default Triangle2D
    System.out.println("The area of the triangle with points at " + t.getP1() + ", " 
      + t.getP2() + ", " + " and " + t.getP3() + " is \nArea = " + t.getArea());
    
    /**  Given 3 points with coordinates p1, p2, and p3 */
    MyPoint p1 = new MyPoint(2.5, 2);
    MyPoint p2 = new MyPoint(4.2, 3);
    MyPoint p3 = new MyPoint(5, 3.5);
    
    // Create an instance t1 with points p1, p2, and p3
    Triangle2D t1 = new Triangle2D(p1, p2, p3);
    
    // Display the coordinates and area of triangle t1
    System.out.println("The area of the triangle with points at " + t1.getP1() + ", " 
      + t1.getP2() + ", " + " and " + t1.getP3() + " is t1 Area = " + t1.getArea());
    
    // Display the perimeter of triangle t1
    System.out.println("It's perimeter is t1 Perimeter = " + t1.getPerimeter());
    
    // Given a point p. Display whether it's contained inside triangle t1
    MyPoint p = new MyPoint(3, 3);
    System.out.println("Is the point located at (3, 3) contained within t1? \nt1 contains point? =  " 
                        + t1.contains(p));
    
    // Given points p1, p2, and p3 create another instance of Triangle2d and check if it's contained inside t1
    p1 = new MyPoint(2.9, 2);
    p2 = new MyPoint(4, 1);
    p3 = new MyPoint(1, 3.4);
    Triangle2D t2 = new Triangle2D(p1, p2, p3);
    System.out.println("How about the triangle with points at ((2.9, 2), (4, 1), (1, 3.4))? " 
                       + "\nAnswer is " + t1.contains(t2));
    
    // Given points p1, p2, and p3 create intance t3 of Triangle2D and check if it overlaps t1
    p1 = new MyPoint(2, 5.5);
    p2 = new MyPoint(4, -3);
    p3 = new MyPoint(2, 6.5);
    Triangle2D t3 = new Triangle2D(p1, p2, p3);
    System.out.println("Does the triangle at ((2, 5.5), (4, -3), (2, 6.5)) overlap t1? \nAnswer is  "
                       + t1.overlaps(t3));
    
  }
  
}