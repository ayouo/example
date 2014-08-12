package com.blogspot.dikuro.example.designpattern.adapter;

public class PrintBanner implements Print {
	private Banner banner;
	public PrintBanner(String string) {
		banner = new Banner(string);
	}
	
	public void printWeak() {
		banner.showWithParen();
	}
	
	public void printStrong() {
		banner.showWithAster();
	}
}
