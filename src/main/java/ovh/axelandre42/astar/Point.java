package ovh.axelandre42.astar;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int distance(Point point, int dz) {
		int dx = this.x - point.x;
		int dy = this.y - point.y;

		return (int) Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2)));
	}

	public int distance(Point point) {
		return distance(point, 0);
	}
}
