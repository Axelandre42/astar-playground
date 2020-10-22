package ovh.axelandre42.astar;

public class Pixel {
	private final int sample;
	private final Position position;

	public Pixel(int sample, Position position) {
		this.sample = sample;
		this.position = position;
	}

	public int getSample() {
		return sample;
	}

	public Position getPosition() {
		return position;
	}
}
