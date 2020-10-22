package ovh.axelandre42.astar;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		GameMap map = new GameMap();
		map.load(new FileInputStream("layer1.bmp"));
		map.run();

		frame.setSize(810, 840);
		frame.add(map);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
