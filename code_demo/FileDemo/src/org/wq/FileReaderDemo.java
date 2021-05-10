package org.wq;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("/home/wq/FileWriter/filewriter.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string="";
        char cahr[] = new char[10];
        int hasread;
        try {

            /*while ((hasread = fileReader.read(cahr)) >0){
                System.out.print(new String(cahr,0,hasread));
            }*/
            while ((string=bufferedReader.readLine())!=null){
                System.out.println(string);
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
