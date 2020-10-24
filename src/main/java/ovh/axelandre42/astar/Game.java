package ovh.axelandre42.astar;

import ovh.axelandre42.astar.tile.Tile;
import ovh.axelandre42.astar.tile.TileLift;
import ovh.axelandre42.astar.tile.TilePavement;
import ovh.axelandre42.astar.tile.TileFloor;
import ovh.axelandre42.astar.util.Position;
import ovh.axelandre42.astar.world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class Game extends JPanel {

	private final World world = new World(WIDTH, LENGTH, 16);
	private final List<Tile> tiles = new ArrayList<>();
	private final JSpinner spinner;

	private static final int TILE_SIZE = 12;
	private static final int WIDTH = 64;
	private static final int LENGTH = 64;
	private static Game game;

	public static void main(String[] args) {
		game = new Game();
	}

	public Game() {
		tiles.add(new TilePavement());
		tiles.add(new TileFloor());
		tiles.add(new TileLift());

		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		GridLayout layout = new GridLayout(0, 2);
		layout.setHgap(10);
		layout.setVgap(10);

		JPanel toolbox = new JPanel(layout);

		JLabel label = new JLabel("Z index");
		toolbox.add(label);

		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 16, 1));
		spinner.addChangeListener(e -> game.repaint());
		toolbox.add(spinner);

		ButtonGroup group = new ButtonGroup();
		Map<UUID, Integer> radioMapping = new HashMap<>();
		for (int i = 0; i < tiles.size(); i++) {
			JRadioButton radio = new JRadioButton(tiles.get(i).getName());
			UUID uuid = UUID.randomUUID();
			radio.setActionCommand(uuid.toString());
			radioMapping.put(uuid, i);
			group.add(radio);
			toolbox.add(radio);
		}

		this.addMouseListener(new MouseListener() {
			private int x, y;

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX() / TILE_SIZE - 1;
				y = e.getY() / TILE_SIZE - 1;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int x = e.getX() / TILE_SIZE - 1;
				int y = e.getY() / TILE_SIZE - 1;

				int dx = Integer.signum(x - this.x);
				int dy = Integer.signum(y - this.y);

				for (int i = this.x; i != x + dx; i += dx) {
					for (int j = this.y; j != y + dy; j += dy) {
						tiles.get(radioMapping.get(UUID.fromString(group.getSelection().getActionCommand())))
								.placeTileAt(world, new Position(i, j, (Integer) spinner.getValue()));
					}
				}

				game.repaint();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		this.setPreferredSize(new Dimension((2 + WIDTH) * TILE_SIZE, (2 + LENGTH) * TILE_SIZE));
		JScrollPane scroll = new JScrollPane(this);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		frame.getContentPane().add(scroll, BorderLayout.CENTER);
		frame.getContentPane().add(toolbox, BorderLayout.EAST);
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getSize().width, this.getSize().height);
		for (Position p : world.getTilePositions()) {
			if (p.getZ() != (Integer) spinner.getValue()) continue;
			Graphics sg = g.create(TILE_SIZE + p.getX() * TILE_SIZE, TILE_SIZE + p.getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
			world.getTileAt(p).draw(sg);
		}

		for (int i = 0; i <= WIDTH; i++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine((1 + i) * TILE_SIZE, TILE_SIZE, (1 + i) * TILE_SIZE, (1 + WIDTH) * TILE_SIZE);
		}

		for (int i = 0; i <= LENGTH; i++) {
			g.setColor(Color.DARK_GRAY);
			g.drawLine(TILE_SIZE, (1 + i) * TILE_SIZE, (1 + LENGTH) * TILE_SIZE, (1 + i) * TILE_SIZE);
		}
	}
}
