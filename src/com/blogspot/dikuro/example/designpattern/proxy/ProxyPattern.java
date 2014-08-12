package com.blogspot.dikuro.example.designpattern.proxy;

public class ProxyPattern {
	
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("이름은 현재" + p.getPrinterName() + "입니다.");
		p.setPrinterName("Bob");
		System.out.println("이름은 현재" + p.getPrinterName() + "입니다.");
		p.print("Hello, world");
	}


}
