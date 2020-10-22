package ovh.axelandre42.astar;

import ovh.axelandre42.astar.tile.AbstractTile;
import ovh.axelandre42.astar.tile.Walk;
import ovh.axelandre42.astar.tile.Wall;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class GameMap extends JPanel {
	private final Grid objects = new Grid(80, 80);

	public GameMap() {
		this.setSize(800, 800);
	}

	public void load(InputStream in) throws IOException {
		objects.load(in, pixel -> pixel.getSample() == 0 ? new Wall(pixel.getPosition()) : null);
	}

	@Override
	public void paint(Graphics g) {
		for (AbstractTile node : objects) {
			if (node instanceof Walk) {
				g.setColor(((Walk) node).getType().getColor());
			} else {
				g.setColor(Color.BLACK);
			}
			g.fillRect(node.getPosition().getX() * 10, node.getPosition().getY() * 10, 10, 10);
		}

		g.setColor(Color.GRAY);
		for (int i = 0; i <= 80; i++) {
			g.drawLine(i * 10, 0, i * 10, 800);
		}
		for (int i = 0; i <= 80; i++) {
			g.drawLine(0, i * 10, 800, i * 10);
		}
	}

	public void run() throws InterruptedException {
		AStarAlgorithm.findPath(objects, new Position(12, 12), new Position(12, 68), this);
	}
}
