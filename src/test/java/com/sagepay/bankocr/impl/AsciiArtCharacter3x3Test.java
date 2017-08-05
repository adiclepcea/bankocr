package com.sagepay.bankocr.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AsciiArtCharacter3x3Test {
	AsciiArtCharacter3x3 asciiArtCharacter;
	
	@Before
	public void init() {
		asciiArtCharacter = new AsciiArtCharacter3x3();
	}
	@Test
	public void TestCharacterNotFound() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '|');
		assertEquals(new Character(' '),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacaterInFirstPos(){
		asciiArtCharacter.setLine(0, 0, '|'); //this should be ignored
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('A'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestSetCharacterValue(){
		//character b 
		//        line 1 = (000) 0 << 6  	
		// |_     line 2 = (110) 6 << 3  	
		// |_|    line 3 = (111) 7
		//
		// 000 110 111 = 55
		asciiArtCharacter.setCharacterValue((byte)55, 'b');
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, ' ');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, ' ');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('b'),asciiArtCharacter.getRepresentation());

	}
	
	@Test
	public void TestCharacterA() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('A'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestAddMoreOnAxis() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		asciiArtCharacter.setLine(3, 2, '|');
		asciiArtCharacter.setLine(2, 3, '|');
		assertEquals(new Character('A'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter1() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, ' ');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, ' ');
		asciiArtCharacter.setLine(1, 1, ' ');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('1'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter2() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, ' ');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, ' ');
		assertEquals(new Character('2'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter3() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, ' ');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('3'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter4() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, ' ');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('4'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter5() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, ' ');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('5'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter6() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, ' ');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('6'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter7() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, ' ');
		asciiArtCharacter.setLine(1, 1, ' ');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, ' ');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('7'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter8() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('8'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter9() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, '_');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, ' ');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('9'),asciiArtCharacter.getRepresentation());
	}
	
	@Test
	public void TestCharacter0() {
		asciiArtCharacter.setLine(0, 0, ' ');
		asciiArtCharacter.setLine(1, 0, '_');
		asciiArtCharacter.setLine(2, 0, ' ');
		asciiArtCharacter.setLine(0, 1, '|');
		asciiArtCharacter.setLine(1, 1, ' ');
		asciiArtCharacter.setLine(2, 1, '|');
		asciiArtCharacter.setLine(0, 2, '|');
		asciiArtCharacter.setLine(1, 2, '_');
		asciiArtCharacter.setLine(2, 2, '|');
		assertEquals(new Character('0'),asciiArtCharacter.getRepresentation());
	}
}
