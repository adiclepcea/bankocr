package com.sagepay.bankocr.impl;

import org.junit.Test;

import com.sagepay.bankocr.base.InvalidSourceException;

import static org.junit.Assert.*;
import org.junit.Before;



public class AsciiArtToStringArrayParserTest {
	
	private AsciiArtToCharacterArrayParser asciiArtParser;
	private static final String testString =
			"    _  _    \n" +
			"  | _| _||_|\n" +
			"  ||_  _|  |";
	
	private static final String testLong =
            " _     _  _     _  _  _  _  _ \n" +
            "| |  | _| _||_||_ |_   ||_||_|\n" +
            "|_|  ||_  _|  | _||_|  ||_| _|";
	
	@Before
	public void init() {
		asciiArtParser = new AsciiArtToCharacterArrayParser();
	}
	
	@Test
	public void TestAcceptNull() {
		assertFalse(asciiArtParser.accept(null));
	}
	
	@Test
	public void TestAcceptUnequalLines() {
		assertFalse(asciiArtParser.accept("|_|\n|_ \n|_|_|"));
		assertEquals("Not all lines have the same length", asciiArtParser.getHint());
	}
	
	@Test
	public void TestAcceptIllegalChars() {
		assertFalse(asciiArtParser.accept("|_|\n   \n---"));
		assertEquals("Invalid character - found", asciiArtParser.getHint());
	}
	
	@Test
	public void TestAcceptWrongLineNumber() {
		assertFalse(asciiArtParser.accept("|_|\n   "));
		assertEquals("Exactly 3 lines expected. Got 2", asciiArtParser.getHint());
	}
	
	@Test
	public void TestAcceptWrongNumberOfCharactersInLine() {
		assertFalse(asciiArtParser.accept("|_|_\n    \n|||_"));
		assertEquals("Incorrect line length", asciiArtParser.getHint());
	}
	
	
	@Test(expected=InvalidSourceException.class)
	public void TestParseNull() throws InvalidSourceException {
		asciiArtParser.parse(null);
	}
	
	@Test
	public void TestParseValidDimensions() {
		try {
			String result = asciiArtParser.parse(testString);
			assertEquals("1234", result);
			
			result = asciiArtParser.parse(testLong);
			assertEquals("0123456789", result);
		}catch(InvalidSourceException ise){
			fail("No exception expected while parsing a valid string. Got: " + ise.getMessage());
		}
	}
}