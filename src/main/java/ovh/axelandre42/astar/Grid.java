package ovh.axelandre42.astar;

import ovh.axelandre42.astar.tile.AbstractTile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Grid implements Iterable<AbstractTile> {
	private final Map<Position, AbstractTile> nodes;
	private final int width;
	private final int height;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.nodes = new HashMap<>(height * width);
	}

	public void put(AbstractTile node) {
		nodes.put(node.getPosition(), node);
	}

	public void load(InputStream in, Function<Pixel, AbstractTile> mapper) throws IOException {
		BufferedImage image = ImageIO.read(in);
		Raster raster = image.getRaster();
		int bands = raster.getNumBands();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				AbstractTile point = mapper.apply(new Pixel(raster.getSample(i, j, 0), new Position(i, j)));
				if (point != null) put(point);
			}
		}
	}

	public AbstractTile getAt(Position position) {
		return nodes.get(position);
	}

	public Set<AbstractTile> getNeighbors(AbstractTile point) {
		Set<AbstractTile> neighbors = new HashSet<>();
		for (Direction direction : Direction.values()) {
			neighbors.add(getAt(point.getPosition().getAdjacentPosition(direction)));
		}
		return neighbors;
	}

	public Set<Position> getNeighborsByPosition(Position point) {
		Set<Position> neighbors = new HashSet<>();
		for (Direction direction : Direction.values()) {
			AbstractTile tile = getAt(point.getAdjacentPosition(direction));
			if (tile != null && tile.isWalkable()) {
				neighbors.add(point.getAdjacentPosition(direction));
			}
		}
		return neighbors;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Iterator<AbstractTile> iterator() {
		return nodes.values().iterator();
	}

	@Override
	public void forEach(Consumer<? super AbstractTile> action) {
		nodes.values().forEach(action);
	}

	@Override
	public Spliterator<AbstractTile> spliterator() {
		return nodes.values().spliterator();
	}
}
