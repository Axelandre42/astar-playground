package ovh.axelandre42.astar.tile;

import java.awt.*;

public class TileFloor extends Tile {
	public TileFloor() {
		this.setColor(Color.YELLOW);
		this.setName("Station floor");
		this.setWalkable(true);
	}
}
