package ovh.axelandre42.astar.tile;

import java.awt.*;

public enum WalkType {
	OPEN(Color.BLUE),
	CLOSED(Color.CYAN),
	PATH(Color.ORANGE),
	START(Color.GREEN),
	END(Color.RED),
	CURRENT(Color.MAGENTA);

	private final Color color;

	WalkType(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
