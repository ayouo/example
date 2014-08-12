package com.blogspot.dikuro.example.algorism.sort.selection;

import java.util.Arrays;

/*
 * 순서대로 정렬시키는 알고리즘
 * 전체 원소들 중에서 기준 위치에 맞는 원소를 선택하여 자리를 교환하는 방식으로 정렬
 * 
 * 1. 전체 원소 중 가장 작은 원소를 찾아 첫번째 원소와 교환
 * 2. 두 번째로 작은 원소를 찾아 두번째 원소와 교환
 * 3. 이과정을 반복
 */

public class SelectionSort {

	public static void main(String[] args) {
		int[] bef = {9, 4, 2, 2, 8};
		
		// java 정렬 API
		/*
		Arrays.sort(bef);
		for(int i=0, len=bef.length; i<len; i++) {
			System.out.println(bef[i]);
		}
		*/
		SelectionSort ss = new SelectionSort();
		ss.sortArray(bef, SelectionSortType.ASC);
		System.out.println();
		ss.sortArray(bef, SelectionSortType.DESC);

	}
	
	public int[] sortArray(int[] bef, SelectionSortType sortType) {
		int[] aft = null;
		switch(sortType) {
			case ASC:
				aft = sortAscArray(bef);
				break;
			case DESC :
				aft = sortDescArray(bef);
				break;
		}
		return aft;
	}
	
	private int[] sortDescArray(int[] bef) {
		int[] aft = bef.clone();
		int tmp;
		
		for(int i=0, lenI=aft.length; i<lenI; i++) {
			int minIdx = i;
			for(int j=i+1, lenJ=aft.length; j<lenJ; j++) {
				if(aft[minIdx] < aft[j]) {
					minIdx = j;
				}
			}
			tmp = aft[i];
			aft[i] = aft[minIdx];
			aft[minIdx] = tmp;
			printArray(aft);
		}
		
		return aft;
	}
	
	private int[] sortAscArray(int[] bef) {
		int[] aft = bef.clone();
		int tmp;
		
		for(int i=0, lenI=aft.length; i<lenI; i++) {
			int minIdx = i;
			for(int j=i+1, lenJ=aft.length; j<lenJ; j++) {
				if(aft[minIdx] > aft[j]) {
					minIdx = j;
				}
			}
			tmp = aft[i];
			aft[i] = aft[minIdx];
			aft[minIdx] = tmp;
			printArray(aft);
		}
		
		return aft;
	}
	
	public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println();
	}
	
}
