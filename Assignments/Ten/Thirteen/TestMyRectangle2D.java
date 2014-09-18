//Author: Luisito Espanola, Elliot J Pleitez
//Date: 2014-09-17

/** Write a test program to test MyRectangle2D class. Create rectangle r1 with fields (2, 2, 5.5, 4.9) Display its area and perimeter. Check if r1 contains point (3, 3) and rectangle(4, 5, 10.5, 3.2)  
Check if it overlaps rectangle(3, 5, 2.3, 5.4) */

class TestMyRectangle2D {

  public static void main(String[] args) {

    MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
    System.out.println("The area of rectangle r1 is Area = " + r1.getArea());
    System.out.println("The perimeter of rectangle r1 is Perimeter = " + r1.getPerimeter());
    System.out.println("Does rectangle r1 contain point(3, 3)? Answer = " + r1.contains(3, 3));
    System.out.println("Does rectangle r1 contain rectangle r(4, 5, 10.5, 3.2)? \nAnswer = " + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
    System.out.println("Does rectangle r1 overlap rectangle r(3, 5, 2.3, 5.4)? \nAnswer = " + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));

  }

}

