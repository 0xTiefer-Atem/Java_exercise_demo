package org.example.fileIo;

import java.io.File;
import java.io.IOException;

public class IOUtilTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtil.copyFile(new File("/home/wq/example/example.txt"), new File(
					"/home/wq/exampleCopy.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
