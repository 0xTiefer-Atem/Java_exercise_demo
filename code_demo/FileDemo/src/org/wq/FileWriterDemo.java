package org.wq;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        File file = new File("/home/wq/FileWriter");
        file.mkdir();
        File file1 = new File("/home/wq/FileWriter/filewriter.txt");

        try {
            file1.createNewFile();
            FileWriter fileWriter = new FileWriter("file1",true);
            fileWriter.write("好好学习, \r\n");
            fileWriter.write("天天向上. \r\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
