package model;

import java.util.ArrayList;

public class Dice {
	private ArrayList<Die> dice;

	public Dice() {
		this.dice = new ArrayList<Die>();
	}

	public void addDie(int i) {
		Die die = new Die(i);
		dice.add(die);
	}

	public String toString() {
		int[] list = { 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < dice.size(); i++) {
			switch (dice.get(i).getFace()) {
			case 4:
				list[0]++;
				break;
			case 6:
				list[1]++;
				break;
			case 8:
				list[2]++;
				break;
			case 10:
				list[3]++;
				break;
			case 12:
				list[4]++;
				break;
			case 20:
				list[5]++;
				break;
			}
		}
		String str = list[0] + "d4 + " + list[1] + "d6 + " + list[2] + "d8 + " + list[3] + "d10 + " + list[4] + "d12 + "
				+ list[5] + "d20";

		return str;
	}

	public ArrayList<Die> getDice() {
		return this.dice;
	}

	public void clear() {
		this.dice = new ArrayList<Die>();
	}
}
