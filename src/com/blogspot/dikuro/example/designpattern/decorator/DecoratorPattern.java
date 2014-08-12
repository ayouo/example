package com.blogspot.dikuro.example.designpattern.decorator;

public class DecoratorPattern {
	public static void main(String[] args) {
		try {
			Display dis = new FullBorder(new StringDisplay("test"));
			Display dis2 = new SideBorder(new StringDisplay("test"), '#');
			
			
			
			for(int i=0; i<dis.getRows(); i++) {
				System.out.println(dis.getRowText(i));
			}
			
			for(int i=0; i<dis2.getRows(); i++) {
				System.out.println(dis2.getRowText(i));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
