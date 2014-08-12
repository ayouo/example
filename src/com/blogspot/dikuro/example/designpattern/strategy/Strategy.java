package com.blogspot.dikuro.example.designpattern.strategy;

public interface Strategy {
	Hand nextHand();
	void study(boolean win);
}
