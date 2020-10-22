package ovh.axelandre42.astar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Grid<P extends Point> implements Iterable<P> {
	private final List<P> points;
	private final int width;
	private final int height;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.points = new ArrayList<>(height * width);
	}

	public void set(P point) {
		points.add(point);
	}

	public void load(InputStream in, Function<Pixel, P> mapper) throws IOException {
		BufferedImage image = ImageIO.read(in);
		Raster raster = image.getRaster();
		int bands = raster.getNumBands();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				P point = mapper.apply(new Pixel(i, j, raster.getSample(i, j, 0)));
				if (point != null) set(point);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Iterator<P> iterator() {
		return points.iterator();
	}

	@Override
	public void forEach(Consumer<? super P> action) {
		points.forEach(action);
	}

	@Override
	public Spliterator<P> spliterator() {
		return points.spliterator();
	}
}
