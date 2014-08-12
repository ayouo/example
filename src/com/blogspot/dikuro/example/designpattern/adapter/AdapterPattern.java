package com.blogspot.dikuro.example.designpattern.adapter;
/**
 * 제공되는 클래스가 제공할 클래스와의 차이를 없애주는 패턴
 * 호환성이 없는 클래스 사이에 하나의 어댑터 클래스를 두어 호환성을 만들어 줌
 * 1. 상속을 통한구현, 2. 위임을 통한 구현
 * @author dikuro
 *
 */
public class AdapterPattern {
	
	public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        
        p.printStrong();
        p.printWeak();
    }
}
