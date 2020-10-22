package ovh.axelandre42.astar;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		Map map = new Map();
		map.load(new FileInputStream("layer1.bmp"));

		frame.setSize(820, 860);
		frame.add(map);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
