package com.blogspot.dikuro.example.designpattern.decorator;

abstract class Border extends Display {
	protected Display display;
	
	protected Border(Display display) {
		this.display = display;
	}
}
