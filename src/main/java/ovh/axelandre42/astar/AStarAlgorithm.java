package ovh.axelandre42.astar;

import ovh.axelandre42.astar.tile.Walk;
import ovh.axelandre42.astar.tile.WalkType;

import java.util.*;

public class AStarAlgorithm {

	public static final int WEIGHT = 10;

	public static Set<Position> findPath(Grid grid, Position start, Position goal, GameMap gameMap) throws InterruptedException {
		PriorityQueue<Node> open = new PriorityQueue<>();
		Node startNode = new Node(start, 0, 0, null);
		open.add(startNode);

		Map<Position, Node> visited = new HashMap<>();
		visited.put(start, startNode);

		while (!open.isEmpty()) {
			Node current = open.poll();
			grid.put(new Walk(current.getPosition(), WalkType.CURRENT));
			grid.put(new Walk(start, WalkType.START));
			grid.put(new Walk(goal, WalkType.END));
			gameMap.repaint();
			Thread.sleep(1);

			if (current.getPosition().equals(goal)) {
				Set<Position> result = new HashSet<>();
				while ((current = current.getParent()) != null) {
					result.add(current.getPosition());
					grid.put(new Walk(current.getPosition(), WalkType.PATH));
					grid.put(new Walk(start, WalkType.START));
					grid.put(new Walk(goal, WalkType.END));
					gameMap.repaint();
					Thread.sleep(1);
				}

				return result;
			}

			for (Position position : grid.getNeighborsByPosition(current.getPosition())) {

				int tentativeGScore = current.getGScore() + 1;
				if (visited.containsKey(position)) {
						if (tentativeGScore < visited.get(position).getGScore()) {
						Node neighbor = visited.get(position);
						neighbor.setParent(current);
						neighbor.setGScore(tentativeGScore);
						neighbor.setFScore(neighbor.getGScore() + WEIGHT * position.distance(goal));
						if (!open.contains(neighbor)) {
							grid.put(new Walk(position, WalkType.OPEN));
							open.add(neighbor);
						}
					}
					continue;
				}
				Node node = new Node(position, tentativeGScore, tentativeGScore + WEIGHT * position.distance(goal),
						current);
				grid.put(new Walk(position, WalkType.CLOSED));
				visited.put(position, node);
				grid.put(new Walk(position, WalkType.OPEN));
				open.add(node);
			}
			grid.put(new Walk(current.getPosition(), WalkType.CLOSED));
		}

		return null;
	}
}
