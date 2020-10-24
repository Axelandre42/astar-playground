package ovh.axelandre42.astar.tile;

import ovh.axelandre42.astar.entity.Entity;
import ovh.axelandre42.astar.util.Direction;
import ovh.axelandre42.astar.util.Position;
import ovh.axelandre42.astar.world.World;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Tile {
	private boolean walkable;
	private Color color;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public boolean canEntityWalkOn(World world, Position position, short metadata, Entity entity) {
		return this.isWalkable();
	}

	public Set<Position> getNeighbors(World world, Position position, short metadata) {
		return Stream.of(Direction.values()).map(position::getNext).collect(Collectors.toSet());
	}

	public void onEntityWalk(World world, Position position, short metadata, Entity entity) {}

	public void placeTileAt(World world, Position position) {
		world.placeTileAt(position, this);
	}

	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
	}
}
