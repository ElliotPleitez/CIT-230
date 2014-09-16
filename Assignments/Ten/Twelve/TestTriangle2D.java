package Ten.Twelve;
import Ten.Four.*;

class TestTriangle2D {
  public static void main(String[] args) {
    Triangle2D t = new Triangle2D();
    System.out.println("The area of the triangle with points at " + t.getP1() + ", " 
      + t.getP2() + ", " + " and " + t.getP3() + " is \nArea = " + t.getArea());
    MyPoint p1 = new MyPoint(2.5, 2);
    MyPoint p2 = new MyPoint(4.2, 3);
    MyPoint p3 = new MyPoint(5, 3.5);
    Triangle2D t1 = new Triangle2D(p1, p2, p3);
    System.out.println("The area of the triangle with points at " + t1.getP1() + ", " 
      + t1.getP2() + ", " + " and " + t1.getP3() + " is t1 Area = " + t1.getArea());
    System.out.println("It's perimeter is t1 Perimeter = " + t1.getPerimeter());
    MyPoint p = new MyPoint(3, 3);
    System.out.println("Is the point located at (3, 3) contained within t1? \nt1 contains point? =  " 
                        + t1.contains(p));
    p1 = new MyPoint(2.9, 2);
    p2 = new MyPoint(4, 1);
    p3 = new MyPoint(1, 3.4);
    System.out.println("How about the triangle with points at ((2.9, 2), (4, 1), (1, 3.4))? " 
                       + "\nAnswer is " + t1.containsTriangle(p1, p2, p3));
    p1 = new MyPoint(2, 5.5);
    p2 = new MyPoint(4, -3);
    p3 = new MyPoint(2, 6.5);
    System.out.println("Does the triangle at ((2, 5.5), (4, -3), (2, 6.5)) overlap t1? \nAnswer is  "
                       + t1.overlapsTriangle(p1, p2, p3));
  }
}