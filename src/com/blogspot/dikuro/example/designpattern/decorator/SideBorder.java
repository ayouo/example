package com.blogspot.dikuro.example.designpattern.decorator;

public class SideBorder extends Border { 
	private char borderChar;
	
	public SideBorder(Display display, char ch) {
		super(display);
		this.borderChar = ch;
	}

	@Override
	public int getColumns() {
		return display.getRows();
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

	@Override
	public String getRowText(int row) {
		return borderChar + display.getRowText(row) + borderChar;
	}

}
