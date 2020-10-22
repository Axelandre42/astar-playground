package ovh.axelandre42.astar;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Map extends Canvas {
	private final Grid<AbstractNode> objects = new Grid<>(80, 80);

	public Map() {
		this.setSize(800, 800);
	}

	public void addNode(AbstractNode node) {
		objects.set(node);
	}

	public void load(InputStream in) throws IOException {
		objects.load(in, pixel -> pixel.getSample() == 0 ? new Wall(pixel.getX(), pixel.getY()) : null);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		for (AbstractNode node : objects) {
			g.fillRect(node.getX() * 10, node.getY() * 10, 10, 10);
		}

		g.setColor(Color.GRAY);
		for (int i = 0; i <= 80; i++) {
			g.drawLine(i * 10, 0, i * 10, 800);
		}
		for (int i = 0; i <= 80; i++) {
			g.drawLine(0, i * 10, 800, i * 10);
		}
	}
}
