package com.blogspot.dikuro.example.designpattern.proxy.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {
	
	private Object targetObj = null;
	
	public HelloWorldHandler(Object target) {
		this.targetObj = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("HelloWorldHandler.invoke() : " + method.getName());
		return method.invoke(targetObj, args);
	}
	
}
