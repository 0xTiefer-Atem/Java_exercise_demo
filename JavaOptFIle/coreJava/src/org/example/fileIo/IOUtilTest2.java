package org.example.fileIo;

import java.io.IOException;

public class IOUtilTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis();
			//IOUtil.printHexByByteArray("/home/wq/example/FileUtils.java");
			//IOUtil.printHex("/home/wq/example/1.mp3");
			IOUtil.printHexByByteArray("/home/wq/example/1.mp3");
			System.out.println();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
