package ovh.axelandre42.astar;

import java.util.Objects;

public class Node implements Comparable<Node> {
	private final Position position;
	private int gScore;
	private int fScore;
	private Node parent;

	public Node(Position position, int gScore, int fScore, Node parent) {
		this.position = position;
		this.gScore = gScore;
		this.fScore = fScore;
		this.parent = parent;
	}

	public Position getPosition() {
		return position;
	}

	public int getGScore() {
		return gScore;
	}

	public int getFScore() {
		return fScore;
	}

	public Node getParent() {
		return parent;
	}

	public void setGScore(int gScore) {
		this.gScore = gScore;
	}

	public void setFScore(int fScore) {
		this.fScore = fScore;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node node = (Node) o;
		return gScore == node.gScore &&
				fScore == node.fScore &&
				position.equals(node.position) &&
				Objects.equals(parent, node.parent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public int compareTo(Node node) {
		return this.getFScore() - node.getFScore();
	}
}
