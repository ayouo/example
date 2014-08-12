package com.blogspot.dikuro.example.designpattern.templatemethod;

/**
 * �߻�(����)Ŭ�������� �߻� �޼ҵ带 ������ �� ��ü���� �޼ҵ� ó�� �帧�� ����(�˰����� �������)�ϰ�
 * �̸� ��ӹ���(����) Ŭ�������� �߻� �޼ҵ带 �����Ͽ� ���� �۾��� �����ϴ� ������ ����(����Ŭ�������� Ư���ܰ� ������)
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
