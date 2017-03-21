package Algorithm;

public class Point {

	int x;
	int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public static int isLeft(final Point P0, final Point P1, final Point P2) {

		return (P0.x - P1.x) * (P2.y - P1.y) - (P2.x - P1.x) * (P0.y - P1.y);

	}

}
