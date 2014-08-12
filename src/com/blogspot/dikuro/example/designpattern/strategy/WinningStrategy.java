package com.blogspot.dikuro.example.designpattern.strategy;

import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;
	private Hand prevHand;
	
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	
	public Hand nextHand() {
		if(!won) {
			prevHand = Hand.values()[random.nextInt(3)];
		}
		return prevHand;
	}
	
	public void study(boolean win) {
		won = win;
	}
}
