package com.blogspot.dikuro.example.algorism.test.bigfile;

public class BigFileSearch {

	public static void main(String[] args) {
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long[] searchNoNumberInFile(String filePath) throws Exception {
		/*
		 * 기준
		 * 1. 파일 IO를 줄여라(한번 리드로 끝내자)
		 * 
		 * 방법
		 * 1. 파일을 순차적으로 읽는다
		 * 2. 1번째 숫자, 2번째 숫자 구간을 만든다-> 예: (1,3), (5,7)
		 * 3. 연속된 숫자는 스킵한다. -> 2 삽입 시 (1,2,3), (5,7) -> 123 삭제해서 (5,7만 남음)
		 * 
		 * 예외
		 * 1. 숫자가 1~80억이고 짝수가 모두 없으면 (1,3) (5,7) 이런식으로 40억개가 생겨 outofmemory
		 * 
		 * 고민 
		 * 1. 리드만 하면 찾을 방법은 없는것인가..
		 */
		long[] result = null;
		
		
		return result;
	}
	
	

}
