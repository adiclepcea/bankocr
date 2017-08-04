package com.sagepay.bankocr.base;

/**
 * General interface for taking in data and getting the Character representation 
 * for that data
 * @author adi
 *
 */
public interface ICharacterRepresenter {
	/**
	 * This method is meant to set up the data that will be parsed by the
	 * implementer of this interface
	 * @param xAxis - the position on the x axis of the where the character is situated
	 * @param yAxis - the position on the y axis of the where the character is situated
	 * @param value - the character from the text representation
	 */
	public void setLine(int xAxis, int yAxis, char value);
	/**
	 * 
	 * @return the Character that represents the data the implementer of this interface received 
	 * by setLine method.
	 */
	public Character getRepresentation();
}
