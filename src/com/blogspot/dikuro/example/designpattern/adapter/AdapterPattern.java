package com.blogspot.dikuro.example.designpattern.adapter;
/**
 * �����Ǵ� Ŭ������ ������ Ŭ�������� ���̸� �����ִ� ����
 * ȣȯ���� ���� Ŭ���� ���̿� �ϳ��� ����� Ŭ������ �ξ� ȣȯ���� ����� ��
 * 1. ����� ���ѱ���, 2. ������ ���� ����
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
