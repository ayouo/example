package com.blogspot.dikuro.example.algorism.sort.selection;

import java.util.Arrays;

/*
 * ������� ���Ľ�Ű�� �˰���
 * ��ü ���ҵ� �߿��� ���� ��ġ�� �´� ���Ҹ� �����Ͽ� �ڸ��� ��ȯ�ϴ� ������� ����
 * 
 * 1. ��ü ���� �� ���� ���� ���Ҹ� ã�� ù��° ���ҿ� ��ȯ
 * 2. �� ��°�� ���� ���Ҹ� ã�� �ι�° ���ҿ� ��ȯ
 * 3. �̰����� �ݺ�
 */

public class SelectionSort {

	public static void main(String[] args) {
		int[] bef = {9, 4, 2, 2, 8};
		
		// java ���� API
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
