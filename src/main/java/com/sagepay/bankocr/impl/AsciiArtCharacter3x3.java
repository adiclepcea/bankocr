package com.sagepay.bankocr.impl;

import java.util.HashMap;
import java.util.Map;

import com.sagepay.bankocr.base.ICharacterRepresenter;

/**
 * 
 * AsciiArtCharacter is a simple 3 by 3 characters ASCI Art representation of a Character
 * It uses bit shifting as a character recognition technique.
 * The default recognized characters are:
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 and A
 * They are represented by:
 *   _     _  _     _  _  _  _  _  _ 
 *  | |  | _| _||_||_ |_   ||_||_||_|
 *  |_|  ||_  _|  | _||_|  ||_| _|| |
 * @author adi
 *
 */
public class AsciiArtCharacter3x3 implements ICharacterRepresenter{
	
	private final byte lines[];	
	private final Map<Byte, Character> knownCharacters = new HashMap<Byte,Character>();
	
	/**
	 * Constructor for AsciiArtCharacter
	 */
	public AsciiArtCharacter3x3() {
		//we just set the values as calculated for the recognized characters
		knownCharacters.put((byte)189, 'A');
		knownCharacters.put((byte)9, '1');
		knownCharacters.put((byte)158, '2');
		knownCharacters.put((byte)155, '3');
		knownCharacters.put((byte)57, '4');
		knownCharacters.put((byte)179, '5');
		knownCharacters.put((byte)183, '6');
		knownCharacters.put((byte)137, '7');
		knownCharacters.put((byte)191, '8');
		knownCharacters.put((byte)187, '9');
		knownCharacters.put((byte)175, '0');
		lines = new byte[3];
	}
	
	/**
	 * Allows you to add or modify the existing values for character representation
	 * @param value 	the byte value that will result after the bit shifting step
	 * @param character the character represented by the value 
	 */
	public void setCharacterValue(byte value, char character){
		knownCharacters.put(value, character);
	}
	
	/**
	 * setLine will set the lines(chars, both vertical and horizontal) 
	 * into the specified position as they are found in the 
	 * AsciiArt character
	 * e.g.
	 *  ________ X
	 * | _				position 1,0
	 * |  |				position 2,1
	 * |
	 * Y
	 * @param xAxis the position of the line on the x axis of the character
	 * @param yAxis the position of the line on the y axis of the character
	 * @param value the read line from the ascii art character 
	 */
	//we only care if we have a | or a _ in the right position
	public void setLine(int xAxis, int yAxis, char value) {
		if(xAxis<3 && yAxis<3) {
			//we do not support 1 on the first line first position as this would overflow byte.
			//we could use integer, but it is not the case in this simple class
			if(xAxis==0 && yAxis==0){
				value=' ';
			}
			//if we have a worthy character, we bit shift it into position
			if(value != ' ') {
				byte pos = 1; 
				pos <<= (2-xAxis);				
				lines[yAxis] |= pos;
			}
		}
	}
	
	/**
	 * Get representation will calculate the character based on the lines receives in setLines
	 * @return the Character corresponding to the lines read from the AsciiArt or ' ' if not found
	 */
	public Character getRepresentation() {
		byte character = (byte) (lines[0] << 6 | lines[1] << 3 | lines[2]);
		return knownCharacters.get(character)==null?' ':knownCharacters.get(character);
	}
}
