package org.example.fileIo;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis();
			/*IOUtil.copyFileByByte(new File("/home/wq/example/1.mp3"), new File(
					"/home/wq/example/2.mp3"));*/  //��������
			/*IOUtil.copyFileByBuffer(new File("/home/wq/example/1.mp3"), new File(
					"/home/wq/example/3.mp3"));//һ������*/
			IOUtil.copyFile(new File("/home/wq/example/1.mp3"), new File(
					"/home/wq/example/4.mp3"));//7����
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}