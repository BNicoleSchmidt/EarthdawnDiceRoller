package model;

public class Die {
	private int face;
	private int rollUps;
	private int end;

	public Die(int face) {
		this.face = face;
		this.rollUps = 0;
	}

	public int getFace() {
		return this.face;
	}

	public int getRollUps() {
		return this.rollUps;
	}

	public void setEnd(int roll) {
		this.end = roll;
	}

	public void rolledUp() {
		this.rollUps++;
	}

	public int getEnd() {
		return this.end;
	}
}
