package model;

import java.util.ArrayList;

public class Dice {
	private int d4 = 0;
	private int d6 = 0;
	private int d8 = 0;
	private int d10 = 0;
	private int d12 = 0;
	private int d20 = 0;

	public Dice() {
	}

	public void addDie(int i) {
		switch (i) {
		case 4:
			d4++;
			break;
		case 6:
			d6++;
			break;
		case 8:
			d8++;
			break;
		case 10:
			d10++;
			break;
		case 12:
			d12++;
			break;
		case 20:
			d20++;
			break;
		}
	}

	public String toString() {
		return d4 + "d4 + " + d6 + "d6 + " + d8 + "d8 + " + d10 + "d10 + " + d12 + "d12 + " + d20 + "d20";
	}

	public ArrayList<Integer> getDice() {
		ArrayList<Integer> dice = new ArrayList<Integer>();
		for (int i = 0; i < d4; i++) {
			dice.add(4);
		}
		for (int i = 0; i < d6; i++) {
			dice.add(6);
		}
		for (int i = 0; i < d8; i++) {
			dice.add(8);
		}
		for (int i = 0; i < d10; i++) {
			dice.add(10);
		}
		for (int i = 0; i < d12; i++) {
			dice.add(12);
		}
		for (int i = 0; i < d20; i++) {
			dice.add(20);
		}
		return dice;
	}
}
