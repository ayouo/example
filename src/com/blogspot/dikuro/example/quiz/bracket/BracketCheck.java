package com.blogspot.dikuro.example.quiz.bracket;

import java.util.Stack;

public class BracketCheck {
	
	public static void main(String[] args) { 
		
		try {
			BracketCheck bc = new BracketCheck();
			String chkStr = "( < { < (<박>) [ ] > } > )";
			System.out.println(chkStr + " : " + bc.checkBracket(chkStr));
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
	public boolean checkBracket(String chkStr) throws BracketInitializeException {
		boolean result = false;
		
		// 1. BracketList를 초기화함 
		BracketList bl = BracketFactory.getBracketList();
		Stack<Bracket> stack = new Stack<Bracket>();
		
		for(int i=0, len=chkStr.length(); i<len; i++) {
			Bracket bracket = null;
			if((bracket = bl.getBracket(chkStr.charAt(i))) == null) {
				continue;
			}
			
			if(bracket.isOpen()) {
				stack.push(bracket);
			} else {
				Bracket openBracket = stack.pop();
				if(!openBracket.isCloseBracket(bracket)) {
					stack.push(openBracket);
					break;
				}
			}
			
		}
		
		if(stack.isEmpty()) {
			result = true;
		}
		
		return result;
	}

}
