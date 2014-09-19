package Ten.Thirteen;

public class TestMyRectangle2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRectangle2D rectangle1 = new MyRectangle2D(0, 0, 5, 5);
		MyRectangle2D rectangle2 = new MyRectangle2D(3, 3, 10, 10);
		MyRectangle2D rectangle3 = new MyRectangle2D(5, 5, 7, 7);

//		System.out.println("Gray Length: " + rectangle1.getLength());
//		System.out.println("Gray Width: " + rectangle1.getWidth());
//		System.out.println("Gray Area is: " + rectangle1.getArea());
//		System.out.println("Gray Perimeter is: " + rectangle1.getPerimeter());
//		System.out.println("Gray Contains Green: " + rectangle1.contains(1, 1));
//		System.out.println("Gray Contains Orange: " + rectangle1.contains(10, 10));
		System.out.println("Brown Contains Red: " + rectangle2.contains(rectangle3));
//		System.out.println("Gray Overlaps Brown: " + rectangle1.overlaps(rectangle2));
	}

}
