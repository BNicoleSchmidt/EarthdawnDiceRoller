package model;

import java.util.Random;

public class Randomizer {
	Random rand = new Random();

	public int randInt(int i) {
		return rand.nextInt(i) + 1;
	}
}
