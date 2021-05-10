package org.example.fileIo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("/home/wq/example/example.txt");
		FileWriter fw = new FileWriter("/home/wq/example/example2.txt");
		//FileWriter fw = new FileWriter("/home/wq/example/example32.txt",true);
		char[] buffer = new char[2056];
		int c ;
		while((c = fr.read(buffer,0,buffer.length))!=-1){
			fw.write(buffer,0,c);
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
