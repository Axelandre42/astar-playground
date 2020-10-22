package ovh.axelandre42.astar.tile;

import ovh.axelandre42.astar.Position;

public class Walk extends AbstractTile {

	private WalkType type;

	public Walk(Position position, WalkType type) {
		super(true, position);
		this.type = type;
	}

	public WalkType getType() {
		return type;
	}

	public void setType(WalkType type) {
		this.type = type;
	}
}
