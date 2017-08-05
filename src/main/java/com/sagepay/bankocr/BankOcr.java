package com.sagepay.bankocr;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sagepay.bankocr.base.InvalidSourceException;
import com.sagepay.bankocr.impl.AsciiArtCharacter3x3;
import com.sagepay.bankocr.impl.AsciiArtToCharacterArrayParser;
import com.sagepay.bankocr.impl.SimpleAsciiArtCharacter;

public class BankOcr {
	private static final String testLong =
            " _     _  _     _  _  _  _  _  _ \n" +
            "| |  | _| _||_||_ |_   ||_||_||_|\n" +
            "|_|  ||_  _|  | _||_|  ||_| _|| |";
	private final AsciiArtToCharacterArrayParser parser = new AsciiArtToCharacterArrayParser();
	private static final Logger logger = Logger.getLogger(BankOcr.class.getName());
	public BankOcr() {
		
	}
	
	public String recognize3x3(String strFromRevolutionaryMachine) throws InvalidSourceException, InstantiationException, IllegalAccessException {
		StringBuffer sbResult = new StringBuffer();
		
		Arrays.stream(parser.parse(strFromRevolutionaryMachine,AsciiArtCharacter3x3.class))
			.forEach(chr->sbResult.append(chr.getRepresentation()));
		
		return sbResult.toString();
	}
	
	public String recognizeSimple(String strFromRevolutionaryMachine) throws InvalidSourceException, InstantiationException, IllegalAccessException {
		StringBuffer sbResult = new StringBuffer();
		
		Arrays.stream(parser.parse(strFromRevolutionaryMachine,SimpleAsciiArtCharacter.class))
			.forEach(chr->sbResult.append(chr.getRepresentation()));
		
		return sbResult.toString();
	}
	
	public static void main(String ...args) {
		BankOcr bankOcr = new BankOcr();
		try {
			System.out.println(String.format("Revolutionary machine sent us:\n%s \nAsciiArtCharacter3x3 translated it to:\n%s", testLong, bankOcr.recognize3x3(testLong)));
			System.out.println(String.format("Revolutionary machine sent us:\n%s \nSimpleAsciiArtChracter translated it to:\n%s", testLong, bankOcr.recognizeSimple(testLong)));
		}catch(InvalidSourceException | InstantiationException | IllegalAccessException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
		}
	}
}