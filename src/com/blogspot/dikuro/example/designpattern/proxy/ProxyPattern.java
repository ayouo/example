package com.blogspot.dikuro.example.designpattern.proxy;

public class ProxyPattern {
	
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		System.out.println("�̸��� ����" + p.getPrinterName() + "�Դϴ�.");
		p.setPrinterName("Bob");
		System.out.println("�̸��� ����" + p.getPrinterName() + "�Դϴ�.");
		p.print("Hello, world");
	}


}
