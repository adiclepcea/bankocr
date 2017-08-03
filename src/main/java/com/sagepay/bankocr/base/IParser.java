package com.sagepay.bankocr.base;

/**
 * IParser is a generic interface that defines the methods 
 * you should implement when you read the information 
 * from an outside source.
 * An IParser should also check for the viability of the source, thus the extension of 
 * {@link IConditionChecker} 
 * @author adic
 *
 */
public interface IParser<U,T> extends IConditionChecker<U> {
	/**
	 * @param source defines the data source for the initial 
	 * data. The returned value is of type T, as needed by the implementer.
	 */
	public T parse(U source) throws InvalidSourceException;

}
