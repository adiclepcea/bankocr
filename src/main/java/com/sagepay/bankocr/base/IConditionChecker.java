package com.sagepay.bankocr.base;

/**
 * IConditionChecker is an interface that defines a <b>accept</b> method.
 * This method should contain the logic saying if the source is suitable or not.
 * 
 * @author adic
 *
 * @param <T> is the source to check for compatibility
 */
public interface IConditionChecker<T> {
	public boolean accept(T source);
}
