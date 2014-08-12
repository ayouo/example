package com.blogspot.dikuro.example.algorism.test.bigfile;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BigFileCreator {

	public static void main(String[] args) {
		try {
			BigFileCreator bfc = new BigFileCreator();
			/*
			Calendar sCal = Calendar.getInstance();
			System.out.println(String.valueOf(sCal.get(Calendar.MINUTE) + ":" + sCal.get(Calendar.SECOND) + ":" + sCal.get(Calendar.MILLISECOND)));
			
			
			//bfc.createNumberBifFile(4000000000L, "D:/data/number.txt", 1000000);
			bfc.createNumberBifFile(1000, "D:/data/number.txt", 100);
			
			Calendar eCal = Calendar.getInstance();
			System.out.println(String.valueOf(eCal.get(Calendar.MINUTE) + ":" + eCal.get(Calendar.SECOND) + ":" + eCal.get(Calendar.MILLISECOND)));
			*/
			
			bfc.createNumberBifFile2(4000000000L, "D:/data/number.txt", 10);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createNumberBifFile2(long numCnt, String filePath, int bufCnt) throws Exception {
		//long[] noNumArr = {91, 53, 12, 17};
		long[] noNumArr = getRandomNumber(numCnt);
		long[][] loopArr = getLoopArray(noNumArr, 1, numCnt+noNumArr.length);
		
		System.out.println("TOTAL CNT : " + (numCnt+noNumArr.length));
		System.out.println("NO CNT : " + noNumArr.length);
		for(int i=0, len=noNumArr.length; i<len; i++) {
			System.out.println(noNumArr[i]);
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)));
		StringBuilder sb = new StringBuilder((bufCnt * 9));
		
		for(int i=0, len=loopArr.length; i<len; i++) {
			
			long idx = loopArr[i][0];
			long lastNum = loopArr[i][1];
			while(true) {
				if(lastNum-idx > bufCnt) {
					for(int j=0; j<bufCnt; j++, idx++) {
						sb.append(String.valueOf(idx) + "\n");	
					}
					bw.write(sb.toString());
					bw.flush();
					sb.delete(0, sb.length());
				} else {
					for(;idx<=lastNum; idx++) {
						sb.append(String.valueOf(idx) + "\n");	
					}
					bw.write(sb.toString());
					bw.flush();
					sb.delete(0, sb.length());
					break;
				}
			} // end of while
		}
		
		bw.flush();
		bw.close();
		
	}
	
	public long[] getRandomNumber(long maxNum) {
		Random random = new Random();
		int noCnt = random.nextInt(10) + 1; // 없어질 숫자는 10개 중 한개
		
		long[] result = new long[noCnt];
		long totalCnt = maxNum + noCnt;
		
		for(int i=0; i<noCnt; i++) {
			long c=0;
			while(c<=0 || c>=totalCnt) {
				int a = random.nextInt((int) (maxNum / 20));
				int b = random.nextInt(20)+1;
				c = a * b;
			}
			result[i] = c;
		}
//		System.out.println("totalCnt : " + totalCnt);
//		System.out.println("noCnt : " + noCnt);
//		for(int i=0, len=result.length; i<len; i++) {
//			System.out.println(i + " : " + result[i]);
//		}
		
		return result;
	}
	
	// 없어지는 값 빼고 반환
	public long[][] getLoopArray(long[] arr, long minNum, long maxNum) {
		long[][] result = new long[arr.length+1][2];
		long[] orderNumArr = orderArray(arr);
		
		result[0][0] = minNum;
		result[0][1] = orderNumArr[0]-1;
		for(int i=1, len=orderNumArr.length; i<len; i++) {
			result[i][0] = orderNumArr[i-1]+1;
			result[i][1] = orderNumArr[i]-1;
		}
		result[result.length-1][0] = orderNumArr[orderNumArr.length-1]+1;
		result[result.length-1][1] = maxNum;
		return result;
	}
			
			
	
	public long[] orderArray(long[] arr) {
		
		long[] result = arr.clone();
		
		for(int i=0, len=result.length; i<len; i++) {
			int minIdx = i;
			//System.out.println(arr[i]);
			for(int j=i+1;j<result.length; j++) {
				if(result[minIdx] > result[j]) {
					minIdx = j;
				}
			}
			long tmp = result[i];
			result[i] = result[minIdx];
			result[minIdx] = tmp;
		}
		
		return result;
	}
	
	public void createNumberBifFile(long numCnt, String filePath, int bufCnt) throws Exception {
		File file = new File(filePath);
		
		/*
		Random random = new Random();
		
		int noCnt = random.nextInt(100) + 1;
		long totalCnt = 4000000000L + noCnt;
		
		Set<Long> noSet = new HashSet<Long>(noCnt);
		
		long c=0;
		for(int i=0; i<noCnt; i++) {
			
			
			while(c<=0 || c>=totalCnt) {
				
				int a = random.nextInt(200000000);
				int b = random.nextInt(20)+1;
				c = a * b;
			}
			System.out.println(c);
			noSet.add(c);
		}
		
		
		
		System.out.println("totalCnt : " + totalCnt);
		System.out.println("noCnt : " + noCnt);
		
		System.out.println(noSet.);
		*/
		
		
		//BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		StringBuffer sb = new StringBuffer((bufCnt + 9));
		
		for(long i=1; i<=numCnt;) {
			for(int j=1; j<=bufCnt; j++, i++) {
				sb.append(String.valueOf(i) + "\n");
				//bw.write(String.valueOf(i));
				//bw.newLine();
			}
			checkDelNum(sb);
			bw.write(sb.toString());
			bw.flush();
			sb.delete(0, sb.length());
		}
		
		bw.flush();
		bw.close();
	}
	
	private void checkDelNum(StringBuffer sb) throws Exception {
		String[] list = {"5", "891", "459", "689", "127"};
		
		for(int i=0, len=list.length; i<len; i++) {
		//	int idx = sb
			System.out.println(sb.toString());
			System.out.println(sb.indexOf("\n" + "4" + "\n"));
		}
	}
	

}
