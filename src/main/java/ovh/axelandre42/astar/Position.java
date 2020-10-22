package ovh.axelandre42.astar;

import java.util.Objects;

public class Position implements Comparable<Position> {
	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int distance(Position position, int dz) {
		int dx = this.x - position.x;
		int dy = this.y - position.y;

		return (int) Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2)));
	}

	public int distance(Position position) {
		return distance(position, 0);
	}

	public Position getAdjacentPosition(Direction direction) {
		return new Position(this.x + direction.getDx(), this.y + direction.getDy());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

	@Override
	public int compareTo(Position position) {
		return (this.x - position.x) + (this.y - position.y);
	}
}
