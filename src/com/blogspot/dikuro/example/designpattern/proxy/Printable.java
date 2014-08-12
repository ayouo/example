package com.blogspot.dikuro.example.designpattern.proxy;

public interface Printable {
	void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
