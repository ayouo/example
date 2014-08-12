package com.blogspot.dikuro.example.designpattern.strategy;

public enum Hand {
	
	GUU("¡÷∏‘", 0),
	CHO("∞°¿ß", 1),
	PAA("∫∏", 2);
	
	private String name;
	private int value;
	
	private Hand(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public boolean isStronngerThan(Hand h) {
		return fight(h) == 1;
	}
	
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}
	
	private int fight(Hand h) {
		if(this == h) {
			return 0;
		} else if((this.getValue() + 1) % 3 == h.getValue()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getValue() {
		return value;
	}

}
