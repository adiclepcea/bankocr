package com.sagepay.bankocr.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import com.sagepay.bankocr.base.ICharacterRepresenter;

/**
 * This a simple class implementing an easily modifiable
 * {@link ICharacterRepresenter}
 * as opposed to  {@link AsciiArtCharacter3x3} it uses a plain text character implementation
 * @author adi
 *
 */

public class SimpleAsciiArtCharacter implements ICharacterRepresenter{

	private char[][] buffer;
	
	private Map<char[][],Character> recognizedCharacters;
	
	private Function<char[][],Character> characterConverter;
	
	/**
	 * Default constructor
	 * <br>
	 * It recognizes the following characters
	 *   _     _  _     _  _  _  _  _  
     *  | |  | _| _||_||_ |_   ||_||_|
     *  |_|  ||_  _|  | _||_|  ||_| _|
	 * 
	 */
	public SimpleAsciiArtCharacter() {
		char[][] _1 = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ','|','|'}};
		char[][] _2 = new char[][]{{' ',' ','|'},{'_','_','_'},{' ','|',' '}};
		char[][] _3 = new char[][]{{' ',' ',' '},{'_','_','_'},{' ','|','|'}};
		char[][] _4 = new char[][]{{' ','|',' '},{' ','_',' '},{' ','|','|'}};
		char[][] _5 = new char[][]{{' ','|',' '},{'_','_','_'},{' ',' ','|'}};
		char[][] _6 = new char[][]{{' ','|','|'},{'_','_','_'},{' ',' ','|'}};
		char[][] _7 = new char[][]{{' ',' ',' '},{'_',' ',' '},{' ','|','|'}};
		char[][] _8 = new char[][]{{' ','|','|'},{'_','_','_'},{' ','|','|'}};
		char[][] _9 = new char[][]{{' ','|',' '},{'_','_','_'},{' ','|','|'}};
		char[][] _0 = new char[][]{{' ','|','|'},{'_',' ','_'},{' ','|','|'}};
		
		HashMap<char[][], Character> initialChars = new HashMap<>();
		initialChars.put(_0, '0');
		initialChars.put(_1, '1');
		initialChars.put(_2, '2');
		initialChars.put(_3, '3');
		initialChars.put(_4, '4');
		initialChars.put(_5, '5');
		initialChars.put(_6, '6');
		initialChars.put(_7, '7');
		initialChars.put(_8, '8');
		initialChars.put(_9, '9');
		
		this.recognizedCharacters = initialChars;
		initializeBuffer();
		initializeCharacterConverter();
	}
	
	/**
	 * Constructor that overwrites the default recognized characters with the one passed
	 * @param recognizedCharacters a Map<char[][], Character> containing the new representation of 
	 * the known characters and their equivalent characters 
	 */
	public SimpleAsciiArtCharacter(Map<char[][], Character> recognizedCharacters){
		this.recognizedCharacters = recognizedCharacters;
		initializeBuffer();
		initializeCharacterConverter();
	}
	
	/**
	 * This method should be use when you want to perform another kind of conversion 
	 * than the default one
	 * @param characterConverter - the function to use when performing the conversion
	 */
	public void setCharacterConverter(Function<char[][],Character> characterConverter){
		this.characterConverter = characterConverter;
	}
	
	/**
	 * Initialize the default function used for character recognition
	 */
	private void initializeCharacterConverter(){
		this.characterConverter = (buf -> {					
			Optional<Character> match = recognizedCharacters.keySet()
				.stream()
				.filter(key->Arrays.deepEquals(key,buffer))
				.map(key->recognizedCharacters.get(key))
				.findAny();			
			return match.isPresent()?match.get():null;
		});
	}
	
	/**
	 * Initialize the buffer that will hold the read ascii characters so that
	 * it can accomodate  all of them  
	 */
	private void initializeBuffer(){
		Optional<Integer> maxWidth = recognizedCharacters.keySet()
			.stream()
			.map(key -> key.length)
			.max((x,y) -> x-y);
		Optional<Integer> maxHeight = recognizedCharacters.keySet()
				.stream()
				.flatMap(x -> Arrays.stream(x))
				.map(key -> key.length)
				.max((x,y) -> x-y);		
		
		buffer = new char[maxWidth.isPresent()?maxWidth.get():0][maxHeight.isPresent()?maxHeight.get():0];
		
	}
	
	/**
	 * 
	 * @return the width of the recognized characters. For the default constructor, the value will be 3
	 * For the parametrized constructor, this is calculated from the map
	 */
	public int getCharacterBufferWidth(){
		return buffer.length;
	}
	
	/**
	 * 
	 * @return the height of the recognized characters. For the default constructor, the value will be 3
	 * For the parametrized constructor, this is calculated from the map
	 */
	public int getCharacterBufferHeight(){
		if(buffer.length==0){
			return 0;
		}
		return buffer[0].length;
	}
	
	@Override
	public void setLine(int xAxis, int yAxis, char value) {
		if(xAxis<getCharacterBufferWidth() && yAxis<getCharacterBufferHeight()) {			
			//if we have a worthy character, we bit shift it into position
			buffer[xAxis][yAxis] = value;
		}
		
	}

	@Override
	public Character getRepresentation() {
		return this.characterConverter.apply(buffer);
	}

}
