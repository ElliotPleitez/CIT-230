package Ten.Four;

class TestMyPoint {
  public static void main(String[] args) {
  /** Create a new point with coordinates at (0, 0) */
    MyPoint p1 = new MyPoint();
  /** Create a new point with coordinates at (10, 30.5) */
    MyPoint p2 = new MyPoint(10, 30.5);
  /** Calculate the distance between the 2 points */
    System.out.println("The distance between point 1 with coordinates" + " (" + p1.getX() + ", "
      + p1.getY() + ") " + "and point 2 with coordinates " + "(" + p2.getX() + ", " + p2.getY() + ") "
      + "is " + p1.getDistance(p2));
    
    
  }
}