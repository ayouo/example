package com.blogspot.dikuro.example.quiz.box;

public class Size {
	
	protected int height;
	protected int width;
	protected int length;
	
	public Size(int height, int width, int length) {
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	public int getMaxSize() {
		return Math.max(this.height, Math.max(this.width, this.length));
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public static void main(String[] args) {
		Size s = new Size(10, 8, 7);
		System.out.println(s.getMaxSize());
	}
}
