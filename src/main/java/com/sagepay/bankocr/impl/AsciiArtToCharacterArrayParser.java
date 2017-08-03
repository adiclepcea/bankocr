package com.sagepay.bankocr.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sagepay.bankocr.base.IParser;
import com.sagepay.bankocr.base.InvalidSourceException;

/**
 * AsciiArtToStringArrayParser is meant to take a string in the form 
 * of a simplified ascii art and return a list with the strings(characters) separated on each line
 * This is a simple parser and it has the following requirements:
 * <ol>
 * <li>The received string should not be null</li>
 * <li>The lines in the string should have the same number of characters</li>
 * <li>The only accepted characters in string besides the new line ('\n') character are:
 * 	<ul>
 *   <li>Vertical line: '|'</li>
 *   <li>Underscore: '_'</li>
 *   <li>Space: ' '</li>
 *  </ul>
 * </li>
 * <li>There should be exactly three lines in the string</li>
 * <li>The number of characters in each line should be a multiple of 3</li>
 * </ol>
 * @author adic
 */
public class AsciiArtToCharacterArrayParser implements IParser<String,String> {
	
	private String lines[];
	private String hint;
	private final List<Character> acceptedCharacters = Arrays.asList('|',' ','_');
	
	/**
	 * @param source is a String that will be converted to a String[]
	 */
	public String parse(String source) throws InvalidSourceException{
		if(!accept(source)) {
			throw new InvalidSourceException("The string you have passed is not valid. Cause: "+hint);
		}
		
		AsciiArtCharacter asciiChars[] = new AsciiArtCharacter[lines[0].length()/3];
		
		for(int y=0;y<3;y++) {
			char[] lineChars = lines[y].toCharArray();
			for(int x=0;x<lineChars.length;x+=3) {
				if(asciiChars[x/3]==null) {
					asciiChars[x/3] = new AsciiArtCharacter();
				}
				asciiChars[x/3].setLine(x%3, y, lineChars[x]);
				asciiChars[x/3].setLine(x%3+1, y, lineChars[x+1]);
				asciiChars[x/3].setLine(x%3+2, y, lineChars[x+2]);
			}
		}
		
		StringBuffer sbResult = new StringBuffer();
		
		Arrays.stream(asciiChars).forEach(chr->sbResult.append(chr.getRepresentation()));
		
		return sbResult.toString();
	}
	
	/**
	 * Get a hint about why the source is not accepted
	 * @return
	 */
	public String getHint() {
		return hint;
	}
	
	/**
	 * accept should check if the input string has the required 
	 * qualities. In this case we are checking for null string,
	 * for line length and for permited characters.
	 * <br>
	 * This method is final. To control the acceptance behaviour 
	 * you have to extend this class and override checkLinesSimple and/or checkLinesDetails 
	 * @param source
	 */
	public final boolean accept(String source) {				
		return checkLinesSimple(source) && checkLinesDetails();
	}
	
	/**
	 * Perform simple checks on the initial String
	 * @param source is the initial String received by the class
	 * @return true if the conditions are met and false otherwise
	 * 
	 */
	protected boolean checkLinesSimple(String source) {
		if (source==null) {
			this.hint = "Null string received";
			return false;
		}
		this.lines = source.split("\n");
				
		//we should have exactly 3 lines in the string
		if(lines.length!=3) {
			this.hint="Exactly 3 lines expected. Got "+lines.length;
			return false;
		}
		
		int lineLength=lines[0].length();
		
		//each character occupied 3 places
		if(lineLength%3!=0) {
			this.hint="Incorrect line length";
			return false;
		}
		return true;
	}
	
	/**
	 * Detailed check for the initial string
	 * @return true if the conditions are met and false otherwise
	 */
	protected boolean checkLinesDetails() {
		int lineLength = lines[0].length();
		for(String line : lines) {
			//check for line length
			if(lineLength!=line.length()) {
				this.hint="Not all lines have the same length";
				return false;
			}
			//check for illegal characters
			Optional<Character> res =  line.chars()
				.mapToObj(c->(char)c)
				.filter(c-> !acceptedCharacters.contains(c))
				.findAny();
			if(res.isPresent()) {
				this.hint="Invalid character "+res.get().toString()+" found";
				return false;
			}
		}
		return true;
	}
}
