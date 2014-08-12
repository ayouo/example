package com.blogspot.dikuro.example.algorism.search.binary;

import com.blogspot.dikuro.example.algorism.sort.selection.SelectionSort;

/**
 * 이진검색
 * 정렬된 데이터를 반으로 나누어서 검색하고자 하는 key가 포함된
 * 부분을 결정한 후 다시 반으로 나누어 검색하는 것을 반복하는 방식
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
