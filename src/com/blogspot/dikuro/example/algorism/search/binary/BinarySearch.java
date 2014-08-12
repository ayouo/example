package com.blogspot.dikuro.example.algorism.search.binary;

import com.blogspot.dikuro.example.algorism.sort.selection.SelectionSort;

/**
 * �����˻�
 * ���ĵ� �����͸� ������ ����� �˻��ϰ��� �ϴ� key�� ���Ե�
 * �κ��� ������ �� �ٽ� ������ ������ �˻��ϴ� ���� �ݺ��ϴ� ���
 * @author dikuro
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] array = {1, 2, 4, 6, 7};
		
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.indexOf(array, 7));

	}
	
	public int indexOf(int[] array, int val) {
		int len = array.length;
		int idx = len / 2;
		
		while(val != array[idx]) {
			if(val<array[idx]) {
				idx = idx/2;
			} else {
				idx = ((len - idx) / 2) + idx;
			}
		}
		
		
		return idx;
		
		
	}

}
