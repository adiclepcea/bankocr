package com.sagepay.bankocr;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.sagepay.bankocr.base.InvalidSourceException;
import com.sagepay.bankocr.impl.AsciiArtToCharacterArrayParser;

public class BankOcr {
	private static final String testLong =
            " _     _  _     _  _  _  _  _  _ \n" +
            "| |  | _| _||_||_ |_   ||_||_||_|\n" +
            "|_|  ||_  _|  | _||_|  ||_| _|| |";
	private final AsciiArtToCharacterArrayParser parser = new AsciiArtToCharacterArrayParser();
	private static final Logger logger = Logger.getLogger(BankOcr.class.getName());
	public BankOcr() {
		
	}
	
	public String recognize(String strFromRevolutioaryMachine) throws InvalidSourceException {
		return parser.parse(strFromRevolutioaryMachine);
	}
	public static void main(String ...args) {
		BankOcr bankOcr = new BankOcr();
		try {
			System.out.println(String.format("Revolutionary machine sent us:\n%s \nWe translated it to:\n%s", testLong, bankOcr.recognize(testLong)));
		}catch(InvalidSourceException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
		}
	}
}