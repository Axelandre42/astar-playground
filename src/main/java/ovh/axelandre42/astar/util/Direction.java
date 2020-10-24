package ovh.axelandre42.astar.util;

public enum Direction {
	NORTH(0, -1, 0),
	SOUTH(0, 1, 0),
	EAST(-1, 0, 0),
	WEST(1, 0, 0),
	UP(0, 0, -1),
	DOWN(0, 0, 1);

	private final int dx;
	private final int dy;
	private final int dz;

	Direction(int dx, int dy, int dz) {
		this.dx = dx;
		this.dy = dy;
		this.dz = dz;
	}

	public int getDX() {
		return dx;
	}

	public int getDY() {
		return dy;
	}

	public int getDZ() {
		return dz;
	}
}
