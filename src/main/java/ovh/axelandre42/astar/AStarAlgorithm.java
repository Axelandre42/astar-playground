package ovh.axelandre42.astar;

public class AStarAlgorithm {
/*
	public static final int WEIGHT = 5;

	private static void put(Target target, Tile tile) {
		target.getLayer().getMap().put(target.getPosition(), tile);
	}

	public static Set<Target> findPath(Target start, Target goal) throws InterruptedException {
		PriorityQueue<Node> open = new PriorityQueue<>();
		Node startNode = new Node(start, 0, 0, null);
		open.add(startNode);

		Map<Target, Node> visited = new HashMap<>();
		visited.put(start, startNode);

		while (!open.isEmpty()) {
			Node current = open.poll();
			put(current.getTarget(), new Walk(WalkType.CURRENT));
			put(start, new Walk(WalkType.START));
			put(goal, new Walk(WalkType.END));

			if (current.getTarget().equals(goal)) {
				Set<Target> result = new HashSet<>();
				while ((current = current.getParent()) != null) {
					result.add(current.getTarget());
				}

				return result;
			}

			MapLayer layer = current.getTarget().getLayer();
			Set<Target> neighbors = layer.getMap().getNeighborsByPosition(current.getTarget());
			for (Target target : neighbors) {

				int tentativeGScore = current.getGScore() + 1;
				if (visited.containsKey(target)) {
						if (tentativeGScore < visited.get(target).getGScore()) {
						Node neighbor = visited.get(target);
						neighbor.setParent(current);
						neighbor.setGScore(tentativeGScore);
						neighbor.setFScore(neighbor.getGScore() + WEIGHT * target.getPosition().distance(goal.getPosition()));
						if (!open.contains(neighbor)) {
							put(target, new Walk(WalkType.OPEN));
							open.add(neighbor);
						}
					}
					continue;
				}
				Node node = new Node(target, tentativeGScore,
						tentativeGScore + WEIGHT * target.getPosition().distance(goal.getPosition()), current);
				put(target, new Walk(WalkType.CLOSED));
				visited.put(target, node);
				put(target, new Walk(WalkType.OPEN));
				open.add(node);
			}
			put(current.getTarget(), new Walk(WalkType.CLOSED));
		}

		return null;
	}*/
}
