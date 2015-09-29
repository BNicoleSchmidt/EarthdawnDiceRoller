package model;

import java.util.ArrayList;

public class Roller {

	private IRollerListener listener;
	private Dice dice = new Dice();
	private boolean explode = true;

	public void roll() {
		String result = "";
		int total = 0;
		ArrayList<Integer> toRoll = dice.getDice();
		ArrayList<Integer> rolled = new ArrayList<Integer>();
		for (int i : toRoll) {
			int roll = (int) ((Math.random() * 100) % i) + 1;
			rolled.add(roll);
			while (roll == i && explode) {
				roll = (int) ((Math.random() * 100) % i) + 1;
				rolled.add(roll);
			}
		}
		for (int i = 0; i < rolled.size(); i++) {
			result += rolled.get(i) + " ";
			total += rolled.get(i);
			if (i < rolled.size() - 1) {
				result += "+ ";
			}
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

	public void explode(boolean b) {
		this.explode = b;
	}
}
