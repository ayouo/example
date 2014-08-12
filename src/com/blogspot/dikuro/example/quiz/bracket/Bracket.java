package com.blogspot.dikuro.example.quiz.bracket;

public class Bracket {
	private char openBracket;
	private char closeBracket;
	private boolean open;
	
	public Bracket(String openCloseBracket) {
		this.openBracket = openCloseBracket.charAt(0);
		this.closeBracket = openCloseBracket.charAt(1);
	}
	
	public Bracket(char openBracket, char closeBracket) {
		this.openBracket = openBracket;
		this.closeBracket = closeBracket;
	}

	public char getOpenBracket() {
		return openBracket;
	}

	public void setOpenBracket(char openBracket) {
		this.openBracket = openBracket;
	}

	public char getCloseBracket() {
		return closeBracket;
	}

	public void setCloseBracket(char closeBracket) {
		this.closeBracket = closeBracket;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public char getOriginBracket() {
		return this.open ? this.openBracket : this.closeBracket;
	}
	
	public boolean isCloseBracket(Bracket bracket) {
		boolean result = false;
		if(!bracket.isOpen()) {
			if(this.closeBracket == bracket.getOriginBracket()) {
				result = true;
			}
		}
		return result;
	}
	
}
