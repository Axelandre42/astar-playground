package ovh.axelandre42.astar.world;

import ovh.axelandre42.astar.entity.Entity;
import ovh.axelandre42.astar.tile.Tile;
import ovh.axelandre42.astar.util.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class World {

	private static class TileHolder {
		private final Tile tile;
		private short metadata;

		public TileHolder(Tile tile, short metadata) {
			this.tile = tile;
			this.metadata = metadata;
		}

		public Tile getTile() {
			return tile;
		}

		public short getMetadata() {
			return metadata;
		}

		public void setMetadata(short metadata) {
			this.metadata = metadata;
		}
	}

	private final Map<Position, TileHolder> tiles = new HashMap<>();
	private final int width;
	private final int length;
	private final int height;

	public World(int width, int length, int height) {
		this.width = width;
		this.length = length;
		this.height = height;
	}

	public void placeTileAt(Position position, Tile tile) {
		tiles.put(position, new TileHolder(tile, (short) 0));
	}

	public void placeTileAt(Position position, Tile tile, short metadata) {
		tiles.put(position, new TileHolder(tile, metadata));
	}

	public Tile getTileAt(Position position) {
		if (isNotInside(position)) throw new IndexOutOfBoundsException(position + " is outside world.");
		return tiles.get(position).getTile();
	}

	public short getTileMetadataAt(Position position) {
		if (isNotInside(position)) throw new IndexOutOfBoundsException(position + " is outside world.");
		return tiles.get(position).getMetadata();
	}

	public boolean hasTileAt(Position position) {
		if (isNotInside(position)) throw new IndexOutOfBoundsException(position + " is outside world.");
		return tiles.containsKey(position);
	}

	public boolean isNotInside(Position position) {
		return position.getX() < 0 || position.getX() >= this.width ||
				position.getY() < 0 || position.getY() >= this.length ||
				position.getZ() < 0 || position.getZ() >= this.height;
	}

	public Set<Position> getTilePositions() {
		return tiles.keySet();
	}

	public Entity getEntityAt(Position position) {
		return null;
	}
}
