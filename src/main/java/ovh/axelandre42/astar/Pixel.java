package ovh.axelandre42.astar;

public class Pixel extends Point {
	private final int sample;

	public Pixel(int x, int y, int sample) {
		super(x, y);
		this.sample = sample;
	}

	public int getSample() {
		return sample;
	}
}
