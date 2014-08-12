package com.blogspot.dikuro.example.quiz.bracket;

public class BracketFactory {
	
	private static final String[]  brackets = {"()", "[]", "{}", "<>"};
	
	public static BracketList getBracketList(String[] brackets) throws BracketInitializeException {
		BracketList bl = new BracketListImpl(brackets);
		return bl;
	}
	
	public static BracketList getBracketList() throws BracketInitializeException {
		BracketList bl = new BracketListImpl(BracketFactory.brackets);
		return bl;
	}

}
