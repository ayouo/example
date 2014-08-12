package com.blogspot.dikuro.example.quiz.stair;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class StairClimb {
	
	public LinkedList<Climber> climb(Stair stair, Climber climber) {
		/*
		 * max step : stairCnt(10)
		 * min step : stairCnt(10) / maxStep(3) = 3.333 => 4  / 10/3 + (int)(Math.ceil(10 % 3))
		 * 
		 * 1. maxStep(3) 수만큼 모든 climber가 생성되어 한걸음씩 걸음(3명의 climber)
		 * 2. 3명이 다시 모든 경우(maxStep)의 수 만큰 한걸음씩 걸음(3*3=9명의 climber)
		 * 3. 위와 같은 방법으로 확장되면서..전체의 현재 계단 위치를 확인해서 10이면 종료.
		 * 4. 모든 climber가 종료될 때까지 진행
		 * 
		 * * 현재 오류 : 마지막에 1계단 남으면 무조건 1, 2, 3 경우의 수만큼 나오는데 1계단, 혹은 2계단 남으면 남은 계단수가 경우의 수가 된다
		 */
		
		//Math.ceil(a)
		
		Queue<Climber> climbers = new LinkedList<Climber>();
		LinkedList<Climber> finishClimbers = new LinkedList<Climber>();
		climbers.add(climber);
		while(!climbers.isEmpty()) {
			Climber c = climbers.poll();
			if(isFinishClimbStair(c, stair)) {
				finishClimbers.add(c);
				continue;
			}
			climbers.addAll(climbStair(c));
		}
		
		return finishClimbers;
	}
	
	public boolean isFinishClimbStair(Climber climber, Stair stair) {
		return climber.getCurrentStep() >= stair.getStairCnt() ? true : false;
	}
	
	public Collection<Climber> climbStair(Climber climber) {
		
		Collection<Climber> climbers = new LinkedList<Climber>();
		for(int step=1, len=climber.getMaxStep()+1; step<len; step++) {
			Climber newClimber = climber.clone();
			newClimber.nextStep(step);
			climbers.add(newClimber);
		}
		
		return climbers;
	}
	
	public static void main(String[] args) {
		StairClimb sc = new StairClimb();
		Climber climber = new Climber(3);
		LinkedList<Climber> climbers = sc.climb(new Stair(5), climber);
		System.out.println("SIZE : " + climbers.size());
		
		Climber[] arrays = new Climber[climbers.size()];
		for(int i=0, len=arrays.length; i<len; i++) {
			arrays[i] = climbers.poll();
		}
		int i=0;
		for(int len=arrays.length; i<len; i++) {
			Climber c = arrays[i];
			System.out.print(c.getStairStep() + " ----> ");
			boolean unique = true;
			for(int j=i+1, len2=arrays.length; j<len2; j++) {
				if(c.getStairStep().equals(arrays[j].getStairStep())) {
					unique = false;
					break;
				}
			}
			System.out.println(unique);
			if(!unique) break;
		}
		System.out.println(arrays.length);
		System.out.println(i);
	}
	
}
