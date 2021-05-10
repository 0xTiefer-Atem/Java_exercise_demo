package org.example.fileIo;

import java.io.IOException;

public class IOUtilTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IOUtil.printHex("/home/wq/example/FileUtils.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
