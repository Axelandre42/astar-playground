package ovh.axelandre42.astar.tile;

import ovh.axelandre42.astar.Position;

public abstract class AbstractTile {
	private final boolean walkable;
	private final Position position;

	public AbstractTile(boolean walkable, Position position) {
		this.walkable = walkable;
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public boolean isWalkable() {
		return walkable;
	}
}
