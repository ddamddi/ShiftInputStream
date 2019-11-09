package shiftInputStream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Testcase1 {
	
	@Test
	void nonOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"));
			
			assertEquals((char) in.read(), 'A');
			assertEquals((char) in.read(), '1');
			assertEquals((char) in.read(), '2');
			assertEquals((char) in.read(), 'z');
			assertEquals((char) in.read(), 'x');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void rightOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), 14);
			
			assertEquals((char) in.read(), 'O');
			assertEquals((char) in.read(), '1');
			assertEquals((char) in.read(), '2');
			assertEquals((char) in.read(), 'n');
			assertEquals((char) in.read(), 'l');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void leftOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), -29);
			
			assertEquals((char) in.read(), 'X');
			assertEquals((char) in.read(), '1');
			assertEquals((char) in.read(), '2');
			assertEquals((char) in.read(), 'w');
			assertEquals((char) in.read(), 'u');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Test
	void nonOffsetReadBytesTest() {
		byte[] bytes = new byte[20];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"));
			in.read(bytes);
			assertEquals("A12zx abc# CX432 A-4", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void rightOffsetReadBytesTest() {
		byte[] bytes = new byte[20];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), 7);
			in.read(bytes);
			assertEquals("H12ge hij# JE432 H-4", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void leftOffsetReadBytesTest() {
		byte[] bytes = new byte[20];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), -34);
			in.read(bytes);
			assertEquals("S12rp stu# UP432 S-4", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void nonOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[25];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"));
			in.read(bytes, 5, 20);
			assertEquals('A', bytes[5]);
			assertEquals('C', bytes[16]);
			assertEquals('2', bytes[20]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void rightOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[25];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), 5);
			in.read(bytes, 5, 20);
			assertEquals('F', bytes[5]);
			assertEquals('H', bytes[16]);
			assertEquals('2', bytes[20]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void leftOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[25];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test2.txt"), -15);
			in.read(bytes, 5, 20);
			assertEquals('2', bytes[7]);
			assertEquals('k', bytes[8]);
			assertEquals('L', bytes[22]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void withOtherDecorator() {
		byte[] bytes = new byte[20];
		try {
			ShiftInputStream in = new ShiftInputStream(new LowerCaseInputStream(new FileInputStream("test2.txt")), 5);
			in.read(bytes);
			assertEquals("f12ec fgh# hc432 f-4", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
