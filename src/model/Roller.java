package model;

import java.util.ArrayList;

public class Roller {

	private IRollerListener listener;
	private Dice dice;
	private boolean explode = true;
	private Randomizer rand;

	public Roller(Randomizer rand, Dice dice) {
		this.rand = rand;
		this.dice = dice;
	}

	public void roll() {
		String result = "";
		int total = 0;
		ArrayList<Die> toRoll = dice.getDice();
		for (Die d : toRoll) {
			int face = d.getFace();
			int roll = rand.randInt(face);
			while (roll == face && explode) {
				d.rolledUp();
				roll = rand.randInt(face);
			}
			d.setEnd(roll);
		}
		for (int i = 0; i < toRoll.size(); i++) {
			Die currDie = toRoll.get(i);
			int rollups = currDie.getRollUps();
			while (rollups > 0) {
				result += "(" + currDie.getFace() + ") + ";
				total += currDie.getFace();
				rollups--;
			}
			result += currDie.getEnd() + " ";
			total += currDie.getEnd();
			if (i < toRoll.size() - 1) {
				result += "+ ";
			}
		}
		result += "= " + total;
		dice.clear();
		notifyListener(result);
	}

	private void notifyListener(String result) {
		if (listener != null) {
			listener.resultRolled(result);
		}
	}

	public void setListener(IRollerListener listener) {
		this.listener = listener;
	}

	public void addDie(int i) {
		dice.addDie(i);
		listener.setToRoll(dice.toString());
	}

	public void explode(boolean b) {
		this.explode = b;
	}
}
