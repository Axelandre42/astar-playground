package ovh.axelandre42.astar.tile;

import java.awt.*;

public class TilePavement extends Tile {
	public TilePavement() {
		this.setColor(Color.LIGHT_GRAY);
		this.setName("Pavement");
		this.setWalkable(true);
	}
}
