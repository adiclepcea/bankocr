package com.sagepay.bankocr.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sagepay.bankocr.base.ICharacterRepresenter;
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
 * <li>The number of characters in each line should be a multiple of charWidth. Default charWidth is 3.</li>
 * </ol>
 * @author adic
 */
public class AsciiArtToCharacterArrayParser implements IParser<String,ICharacterRepresenter> {
	
	private String lines[];
	private String hint;
	private final List<Character> acceptedCharacters = Arrays.asList('|',' ','_');
	private int charWidth; //the width of the character representation
	private int charHeight; //the width of the character representation
	
	/**
	 * Default constructor. This will set the width and the height of the
	 * representation to 3
	 */
	public AsciiArtToCharacterArrayParser(){
		this(3,3);
	}
	
	/**
	 * Constructor with width and height parameters for the character representation
	 * You should use this if you have an ICharacterRepresenter implementer that is not 3 by 3 chars.
	 * Please note that such an ICharacterRepresenter implementation is not shipped with this library 
	 * @param charWidth
	 * @param charHeight
	 */
	public AsciiArtToCharacterArrayParser(int charWidth, int charHeight){
		this.charWidth = charWidth;
		this.charHeight = charHeight;
	}
	
	/**
	 * @param source is a String that will be converted to a ICharacterRepresenter[]
	 */
	public ICharacterRepresenter[] parse(String source,Class <? extends ICharacterRepresenter> c) throws InvalidSourceException{
		if(!accept(source)) {
			throw new InvalidSourceException("The string you have passed is not valid. Cause: "+hint);
		}
		
		ICharacterRepresenter asciiChars[] = (ICharacterRepresenter [])Array.newInstance(c, lines[0].length()/charWidth);
		
		for(int y=0;y<charHeight;y++) {
			char[] lineChars = lines[y].toCharArray();
			for(int x=0;x<lineChars.length;x+=charWidth) {
				int charIndex = x/charWidth; 
				if(asciiChars[charIndex]==null) {
					asciiChars[charIndex] = new AsciiArtCharacter();
				}
				asciiChars[charIndex].setLine(x%charWidth, y, lineChars[x]);
				asciiChars[charIndex].setLine(x%charWidth+1, y, lineChars[x+1]);
				asciiChars[charIndex].setLine(x%charWidth+2, y, lineChars[x+2]);
			}
		}
		
		
		return asciiChars;
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
				
		//we should have exactly charHeight lines in the string
		if(lines.length!=charHeight) {
			this.hint="Exactly "+charHeight+" lines expected. Got "+lines.length;
			return false;
		}
		
		int lineLength=lines[0].length();
		
		//each character occupied charWidth places
		if(lineLength%charWidth!=0) {
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
