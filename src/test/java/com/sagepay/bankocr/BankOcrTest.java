package com.sagepay.bankocr;

import org.junit.Test;

import com.sagepay.bankocr.base.InvalidSourceException;

import static org.junit.Assert.*;

public class BankOcrTest {

    private static final String test =
        "    _  _    \n" +
        "  | _| _||_|\n" +
        "  ||_  _|  |";
    
    private static final String testLong =
            " _     _  _     _  _  _  _  _ \n" +
            "| |  | _| _||_||_ |_   ||_||_|\n" +
            "|_|  ||_  _|  | _||_|  ||_| _|";

    // expected output either 1234 or "1234"

    @Test
    public void test() {
    	BankOcr  bankOcr = new BankOcr();
    	try {
    		assertEquals("1234",bankOcr.recognize(test));
    	}catch(InvalidSourceException ise) {
    		fail("No exception expected while recogniizing a valid AsciiArt string");
    	}
    }
    
    


}
