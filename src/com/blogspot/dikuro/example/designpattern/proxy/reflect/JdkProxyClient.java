package com.blogspot.dikuro.example.designpattern.proxy.reflect;

import java.lang.reflect.Proxy;

public class JdkProxyClient {
	public static void main(String[] args) {
		try {
			Class[] arrClass = {HelloWorld.class};
			HelloWorldHandler handler = new HelloWorldHandler(new HelloWorldImpl());
			HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(HelloWorld.class.getClassLoader(), arrClass, handler);
			proxy.sayHello("name..");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
