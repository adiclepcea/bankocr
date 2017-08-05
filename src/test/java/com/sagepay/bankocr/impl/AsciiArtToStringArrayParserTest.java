package com.sagepay.bankocr.impl;

import org.junit.Test;

import com.sagepay.bankocr.base.ICharacterRepresenter;
import com.sagepay.bankocr.base.InvalidSourceException;

import static org.junit.Assert.*;

import java.util.Arrays;

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
	
	public static String getStringRepresentation(ICharacterRepresenter[] chars){
		StringBuffer sbResult = new StringBuffer();
		
		Arrays.stream(chars).forEach(chr->sbResult.append(chr.getRepresentation()));
		
		return sbResult.toString();
	}
	
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
	public void TestParseNull() throws InvalidSourceException, InstantiationException, IllegalAccessException {
		asciiArtParser.parse(null,null);
	}
	
	@Test
	public void TestParseValidDimensions() throws InstantiationException, IllegalAccessException {
		try {
			String result = getStringRepresentation(asciiArtParser.parse(testString,AsciiArtCharacter3x3.class));
			assertEquals("1234", result);
			
			result = getStringRepresentation(asciiArtParser.parse(testLong,AsciiArtCharacter3x3.class));
			assertEquals("0123456789", result);
		}catch(InvalidSourceException ise){
			fail("No exception expected while parsing a valid string. Got: " + ise.getMessage());
		}
	}
}
