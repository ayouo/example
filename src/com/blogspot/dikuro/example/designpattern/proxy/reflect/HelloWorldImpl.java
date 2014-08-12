package com.blogspot.dikuro.example.designpattern.proxy.reflect;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello(String msg) {
		System.out.println("HelloWorldImpl.sayHello() : " + msg);
		
	}
	
}
