package ovh.axelandre42.astar;

public abstract class AbstractNode extends Point {
	private boolean walkable;

	public AbstractNode(int x, int y, boolean walkable) {
		super(x, y);
		this.walkable = walkable;
	}

	public boolean isWalkable() {
		return walkable;
	}
}
