package model;

public class DieResult {

	private int face;
	private int rollUps;
	private int end;

	public DieResult(int face, int rollUps, int end) {
		this.face = face;
		this.rollUps = rollUps;
		this.end = end;
	}

	public int getFace() {
		return this.face;
	}

	public int getRollUps() {
		return this.rollUps;
	}

	public int getEnd() {
		return this.end;
	}
}
