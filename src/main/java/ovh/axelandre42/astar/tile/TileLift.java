package ovh.axelandre42.astar.tile;

import ovh.axelandre42.astar.util.Direction;
import ovh.axelandre42.astar.util.Position;
import ovh.axelandre42.astar.world.World;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TileLift extends Tile {

	public TileLift() {
		this.setColor(Color.ORANGE);
		this.setName("Lift");
		this.setWalkable(true);
	}

	@Override
	public Set<Position> getNeighbors(World world, Position position, short metadata) {
		Direction orientation = Direction.values()[metadata % 4];
		Set<Position> result =
				Stream.of(Direction.values()).filter(d -> !d.equals(orientation)).map(position::getNext).collect(Collectors.toSet());
		if ((metadata / 4) % 2 == 1) result.add(position.getNext(orientation).getNext(Direction.UP));
		if ((metadata / 8) % 2 == 1) result.add(position.getNext(orientation).getNext(Direction.DOWN));
		return result;
	}

	@Override
	public void placeTileAt(World world, Position position) {
		Position output = position.getNext(Direction.NORTH).getNext(Direction.DOWN);
		if (world.isNotInside(output)) return;

		world.placeTileAt(position, this, (short) (Direction.NORTH.ordinal() + 8));
		world.placeTileAt(output, this, (short) (Direction.SOUTH.ordinal() + 4));
	}
}
