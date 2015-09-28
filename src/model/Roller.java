package model;

public class Roller {

	public int roll(int i) {
		int num = (int) (Math.random() * 10) % 6;
		System.out.print(num + 1);
		return num + 1;
	}
}
