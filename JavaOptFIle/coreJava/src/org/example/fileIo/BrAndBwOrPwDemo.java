package org.example.fileIo;

import java.io.*;

public class BrAndBwOrPwDemo {
	public static void main(String[] args) throws IOException {
		//���ļ����ж�д����
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
			System.out.println(line);//һ�ζ�һ�У�������ʶ����
			/*bw.write(line);
			//����д�����в���
			bw.newLine();//���в���
			bw.flush();*/
			pw.println(line);
			pw.flush();
		}
		br.close();
		//bw.close();
		pw.close();
	}

}