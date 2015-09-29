package model;

import java.util.ArrayList;

public class Roller {

	private IRollerListener listener;
	private Dice dice = new Dice();

	public void roll() {
		String result = "";
		int total = 0;
		ArrayList<Integer> toRoll = dice.getDice();
		for (int i : toRoll) {
			int roll = (int) ((Math.random() * 100) % i) + 1;
			result += roll + " ";
			total += roll;
		}
		result += "= " + total;
		dice = new Dice();
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
}
