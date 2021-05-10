package org.example.fileIo;

import java.io.*;

public class BrAndBwOrPwDemo {
	public static void main(String[] args) throws IOException {
		//对文件进行读写操作
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("/home/wq/example.txt")));
		/*BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("/home/wq/example/example3.txt")));*/
		PrintWriter pw = new PrintWriter("/home/wq/example4.txt");
		//PrintWriter pw1 = new PrintWriter(outputStream,boolean autoFlush);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);//一次读一行，并不能识别换行
			/*bw.write(line);
			//单独写出换行操作
			bw.newLine();//换行操作
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}

}
