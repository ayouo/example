package com.blogspot.dikuro.example.quiz.box;

public class Item extends Size {
	
	private String itemNm;
	private int rotateNumber;
	
	
	
	public Item(String itemNm, int height, int width, int length) {
		super(height, width, length	);
		this.itemNm = itemNm;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	
	public int rotate(int number) {
		return 0;
	}

}
