package shiftInputStream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class Testcase2 {
	
	@Test
	void nonOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"));
			
			assertEquals((char) in.read(), 'G');
			assertEquals((char) in.read(), 'y');
			assertEquals((char) in.read(), 'e');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void rightOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), 14);
			
			assertEquals((char) in.read(), 'U');
			assertEquals((char) in.read(), 'm');
			assertEquals((char) in.read(), 's');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void leftOffsetNonParamReadTest() {
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), -17);
			
			assertEquals((char) in.read(), 'P');
			assertEquals((char) in.read(), 'h');
			assertEquals((char) in.read(), 'n');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Test
	void nonOffsetReadBytesTest() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"));
			in.read(bytes);
			assertEquals("Gyeong-Hyeon Kim #20144320", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	void rightOffsetReadBytesTest() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), 11);
			in.read(bytes);
			assertEquals("Rjpzyr-Sjpzy Vtx #20144320", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void leftOffsetReadBytesTest() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), -32);
			in.read(bytes);
			assertEquals("Asyiha-Bsyih Ecg #20144320", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void nonOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"));
			in.read(bytes, 5, 20);
			assertEquals('G', bytes[5]);
			assertEquals('o', bytes[15]);
			assertEquals('m', bytes[20]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void rightOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[31];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), 5);
			in.read(bytes, 5, 26);
			assertEquals('L', bytes[5]);
			assertEquals('t', bytes[15]);
			assertEquals('r', bytes[20]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void leftOffsetReadBytesWithOffsetTest() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new FileInputStream("test.txt"), -44);
			in.read(bytes, 5, 20);
			assertEquals('m', bytes[7]);
			assertEquals('w', bytes[8]);
			assertEquals('#', bytes[22]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void withOtherDecorator() {
		byte[] bytes = new byte[26];
		try {
			ShiftInputStream in = new ShiftInputStream(new LowerCaseInputStream(new FileInputStream("test.txt")), 4);
			in.read(bytes);
			assertEquals("kcisrk-lcisr omq #20144320", new String(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
