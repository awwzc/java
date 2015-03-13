package gogoogle.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestIo {
	public static void main(String[] args) throws FileNotFoundException {
	//	InputStream in = new FileInputStream("D:/test.txt");
		OutputStream out = new FileOutputStream("D:/test.txt");
		try {
			out.write(1023);
			out.write(1023);
			//out.close();
			//in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
