package ovh.axelandre42.astar;

import java.util.*;

public class AStarAlgorithm {

	public static Set<Position> findPath(Grid grid, Position start, Position goal) {
		PriorityQueue<Node> open = new PriorityQueue<>();
		open.add(new Node(start, 0, 0, null));

		Map<Position, Node> visited = new HashMap<>();

		while (!open.isEmpty()) {
			Node current = open.poll();
			if (current.getPosition() == goal) {
				Set<Position> result = new HashSet<>();
				while ((current = current.getParent()) != null) {
					result.add(current.getPosition());
				}
				return result;
			}

			for (Position position : grid.getNeighborsByPosition(current.getPosition())) {
				int tentativeGScore = current.getGScore() + 1;
				if (visited.containsKey(position) && tentativeGScore < visited.get(position).getGScore()) {
					Node node = visited.get(position);
					node.setParent(current);
					node.setGScore(tentativeGScore);
					node.setFScore(node.getGScore() + position.distance(goal));
					if (!open.contains(node)) {
						open.add(node);
					}
					continue;
				}
				Node node = new Node(position, tentativeGScore, tentativeGScore + position.distance(goal), current);
				visited.put(position, node);
				if (!open.contains(node)) {
					open.add(node);
				}
			}
		}

		return null;
	}
}
