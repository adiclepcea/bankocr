package com.sagepay.bankocr.base;

/**
 * Exception tothrow when the source is invalid
 * @author adic
 *
 */
public class InvalidSourceException extends Exception {

	private static final long serialVersionUID = -7476989320451944771L;
	
	public InvalidSourceException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
