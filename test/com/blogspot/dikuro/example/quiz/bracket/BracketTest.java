package com.blogspot.dikuro.example.quiz.bracket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BracketTest {
	BracketCheck bc;
	
	@Before
	public void setUp() throws Exception {
		bc = new BracketCheck();
	}
	
	@After
	public void tearDown() throws Exception {
		bc = null;
	}
	
	
	@Test
	public void test() throws BracketInitializeException {
		String trueStr = "()()";
		assertTrue(bc.checkBracket(trueStr));
		
		String falseStr = "((((())))";
		assertFalse(bc.checkBracket(falseStr));
	}
	
	public void test2() throws BracketInitializeException {
		String trueStr = "()()(";
		assertTrue(bc.checkBracket(trueStr));
		
		String falseStr = "((((())))";
		assertFalse(bc.checkBracket(falseStr));
	}

}
