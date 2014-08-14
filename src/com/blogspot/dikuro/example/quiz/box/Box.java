package com.blogspot.dikuro.example.quiz.box;

import java.util.LinkedList;
import java.util.List;

public class Box extends Size {
	
	private String boxNm;
	private boolean[][][] inside;
	private List<Item> items;

	public Box(String boxNm, int height, int width, int length) {
		super(height, width, length);
		this.boxNm = boxNm;
		this.inside = new boolean[super.height][super.width][super.length];
		this.items = new LinkedList<Item>();
	}
	
	public void addItem(Item item) {
		
	}
	
	public boolean isPossibleInBox(Item item) {
		return getMaxSize() <= item.getMaxSize() ? true : false;
	}
	
	public String getBoxNm() {
		return boxNm;
	}


	public void setBoxNm(String boxNm) {
		this.boxNm = boxNm;
	}

}
