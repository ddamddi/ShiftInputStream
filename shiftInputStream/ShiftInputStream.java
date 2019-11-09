package shiftInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShiftInputStream extends FilterInputStream {
	private int offset;
	private int converted_offset;
	
	public ShiftInputStream(InputStream in) {
		super(in);
		setOffset(0);
	}
		
	public ShiftInputStream(InputStream in, int offset) {
		super(in);
		setOffset(offset);
	}
	
	public static void main(String[] args) {
		try {
			ShiftInputStream in = new ShiftInputStream(
					new FileInputStream("test.txt"), 1);

			byte[] bytes = new byte[26];
			in.read(bytes);
			System.out.println(new String(bytes));
			
			in.close();
		} catch (IOException e){
			e.printStackTrace();
		}	
	}
	
	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
		this.converted_offset = offset;
		
		while(converted_offset < 0) {
			converted_offset += 26;
		}
		converted_offset %= 26;
	}

	public int read() throws IOException {
		int c = super.read();
		if(c >= 'A' && c <= 'Z') {
			c = c + converted_offset;
			c = (c > 'Z' ? c % 'Z' + 'A' - 1 : c); 
		}
		else if (c >= 'a' && c <= 'z') {
			c = c + converted_offset;
			c = (c > 'z' ? c % 'z' + 'a' - 1 : c); 
		}
		return c;
	}
	
	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);	
	}
	
	public int read(byte[] b, int off, int len) throws IOException {
		int read_byte;
		for(read_byte = 0; read_byte < len; read_byte++) {
			byte result;
			if((result = (byte) this.read()) < 0)
				break;
			else
				b[off + read_byte] = result;
		}
		return read_byte;
	}

}
