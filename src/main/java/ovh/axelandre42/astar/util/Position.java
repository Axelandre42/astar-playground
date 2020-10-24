package ovh.axelandre42.astar.util;

import java.util.Objects;

public class Position {

	// --- Fields, constructor and getters ---

	private final int x, y, z;

	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	// --- Utilities ---

	public Position getNext(Direction direction) {
		return new Position(this.x + direction.getDX(), this.y + direction.getDY(), this.z);
	}

	// --- Overrides ---

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return x == position.x &&
				y == position.y &&
				z == position.z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}

	@Override
	public String toString() {
		return "(" + x +
				"," + y +
				"," + z +
				')';
	}
}
