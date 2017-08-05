package com.sagepay.bankocr.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;

public class SimpleAsciiArtCharacterTest {

	SimpleAsciiArtCharacter asciiArtCharacter;
	SimpleAsciiArtCharacter asciiArtCharacterModif;
	HashMap<char[][],Character> recognizedCharacters = new HashMap<>();
	
	public SimpleAsciiArtCharacterTest() {
		char[][] _1 = new char[][]{{' ',' ',' ',' '},{' ',' ',' ',' '},{' ','|','|',' '}};
		char[][] _2 = new char[][]{{' ',' ','|',' '},{'_','_','_',' '},{' ','|',' ',' '}};
		char[][] _3 = new char[][]{{' ',' ',' ',' '},{'_','_','_',' '},{' ','|','|',' '}};
		char[][] _4 = new char[][]{{' ','|',' ',' '},{' ','_',' ',' '},{' ','|','|',' '}};
		char[][] _5 = new char[][]{{' ','|',' ',' '},{'_','_','_',' '},{' ',' ','|',' '}};
		char[][] _6 = new char[][]{{' ','|','|',' '},{'_','_','_',' '},{' ',' ','|',' '}};
		char[][] _7 = new char[][]{{' ',' ',' ',' '},{'_',' ',' ',' '},{' ','|','|',' '}};
		char[][] _8 = new char[][]{{' ','|','|',' '},{'_','_','_',' '},{' ','|','|',' '}};
		char[][] _9 = new char[][]{{' ','|',' ',' '},{'_','_','_',' '},{' ','|','|',' '}};
		char[][] _0 = new char[][]{{' ','|','|',' '},{'_',' ','_',' '},{' ','|','|',' '}};
		recognizedCharacters.put(_0, '0');
		recognizedCharacters.put(_1, '1');
		recognizedCharacters.put(_2, '2');
		recognizedCharacters.put(_3, '3');
		recognizedCharacters.put(_4, '4');
		recognizedCharacters.put(_5, '5');
		recognizedCharacters.put(_6, '6');
		recognizedCharacters.put(_7, '7');
		recognizedCharacters.put(_8, '8');
		recognizedCharacters.put(_9, '9');
	}
	
	@Before
	public void init(){
		asciiArtCharacter = new  SimpleAsciiArtCharacter();
		asciiArtCharacterModif = new  SimpleAsciiArtCharacter(recognizedCharacters);
	}

	@Test
	public void NewSimpleAsciiArtCharacterDefaultConstructorTest(){		
		
		SimpleAsciiArtCharacter saac = new SimpleAsciiArtCharacter();
		assertEquals(3, saac.getCharacterBufferWidth());
		assertEquals(3, saac.getCharacterBufferHeight());
	}
	
	@Test
	public void NewSimpleAsciiArtCharacterParamsConstructorTest(){
		
		SimpleAsciiArtCharacter saac = new SimpleAsciiArtCharacter(recognizedCharacters);
		assertEquals(3, saac.getCharacterBufferWidth());
		assertEquals(4, saac.getCharacterBufferHeight());
	}
	
	@Test
	public void TestCharacter1Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, ' ');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, ' ');
		asciiArtCharacterModif.setLine(1, 1, ' ');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, ' ');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('1'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter2Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, ' ');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, '|');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, ' ');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('2'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter3Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, ' ');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('3'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter4Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, ' ');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, ' ');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('4'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter5Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, ' ');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('5'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter6Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, ' ');
		asciiArtCharacterModif.setLine(0, 2, '|');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('6'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter7Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, ' ');
		asciiArtCharacterModif.setLine(1, 1, ' ');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, ' ');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('7'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter8Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, '|');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('8'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter9Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, '_');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, ' ');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('9'),asciiArtCharacterModif.getRepresentation());
	}
	
	@Test
	public void TestCharacter0Modif() {
		asciiArtCharacterModif.setLine(0, 0, ' ');
		asciiArtCharacterModif.setLine(1, 0, '_');
		asciiArtCharacterModif.setLine(2, 0, ' ');
		asciiArtCharacterModif.setLine(0, 1, '|');
		asciiArtCharacterModif.setLine(1, 1, ' ');
		asciiArtCharacterModif.setLine(2, 1, '|');
		asciiArtCharacterModif.setLine(0, 2, '|');
		asciiArtCharacterModif.setLine(1, 2, '_');
		asciiArtCharacterModif.setLine(2, 2, '|');
		asciiArtCharacterModif.setLine(0, 3, ' ');
		asciiArtCharacterModif.setLine(1, 3, ' ');
		asciiArtCharacterModif.setLine(2, 3, ' ');
		assertEquals(new Character('0'),asciiArtCharacterModif.getRepresentation());
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
