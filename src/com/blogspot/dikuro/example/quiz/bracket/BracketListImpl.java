package com.blogspot.dikuro.example.quiz.bracket;

import java.util.HashMap;

public class BracketListImpl implements BracketList {
	
	private HashMap<Character, Bracket> map = new HashMap<Character, Bracket>();
	
	public BracketListImpl(String[] brackets) throws BracketInitializeException {
		for(int i=0, len=brackets.length; i<len; i++) {
			String str = brackets[i];
			
			if(str.length() != 2) {
				throw new BracketInitializeException();
			}
			
			Bracket bracket = new Bracket(str);
			this.map.put(bracket.getOpenBracket(), bracket);
			this.map.put(bracket.getCloseBracket(), bracket);
		}
	}

	@Override
	public Bracket getBracket(char c) {
		Bracket bracket = null;
		Bracket sample = this.map.get(c);
		if(sample != null) {
			bracket = new Bracket(sample.getOpenBracket(), sample.getCloseBracket());
			boolean open = bracket.getOpenBracket() == c ? true : false;
			bracket.setOpen(open);
		}  
		return bracket;
	}

}
