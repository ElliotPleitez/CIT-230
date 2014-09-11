package Ten.Twelve;

public class Testing {

	public static void main(String[] args) {
		Triangle2D triangle1 = new Triangle2D(0, 1, 2, 3, 3, 1);
		Triangle2D triangle2 = new Triangle2D(3, 0, 3, 2, 4, 0);

		System.out.println("Area of triangle: " + triangle1.getArea());
		System.out.println("Perimeter of triangle: " + triangle1.getPerimeter());
		Ten.Four.MyPoint point = new Ten.Four.MyPoint(2, 2);
		System.out.println("Point lies within triangle: " + triangle1.contains(point));
		System.out.println("Triangle overlaps: " + triangle1.overlaps(triangle2));
	}

}
