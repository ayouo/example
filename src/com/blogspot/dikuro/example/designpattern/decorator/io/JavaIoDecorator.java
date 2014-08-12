package com.blogspot.dikuro.example.designpattern.decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class JavaIoDecorator {
	
	public static void main(String[] args) {
		try {
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(""));
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
