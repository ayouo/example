package com.blogspot.dikuro.example.designpattern.templatemethod;

/**
 * 추상(상위)클래스에서 추상 메소드를 정의한 후 전체적인 메소드 처리 흐름을 정의(알고리즘의 골격정의)하고
 * 이를 상속받은(하위) 클래스에서 추상 메소드를 구현하여 실제 작업을 결정하는 디자인 패턴(서브클래스에서 특정단계 재정의)
 * @author dikuro
 *
 */
public class TemplateMethodPattern {
	
	public static void main(String[] args) {
		try {
			AbstractDisplay d1 = new CharDisplay('H');
			AbstractDisplay d2 = new StringDisplay("Hello, Template");
			
			d1.display();
			d2.display();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
