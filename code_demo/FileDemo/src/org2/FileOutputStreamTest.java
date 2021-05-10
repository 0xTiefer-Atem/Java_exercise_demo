package org2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        try{
            FileInputStream fis = new FileInputStream("/home/wq/FileWriter/filewriter.txt");
            File f = new File("/home/wq/FileOutputStream");
            f.mkdir();
            File file = new File("/home/wq/FileOutputStream/text.txt");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream("/home/wq/FileOutputStream/text.txt",true);


            /*File tempfile = File.createTempFile("aaa",".txt",f);
            System.in.read();
            tempfile.deleteOnExit();*/
            byte[] bbuf = new byte[10];
            int hasRead = 0;
            while ((hasRead = fis.read(bbuf)) > 0 )
            {
                fos.write(bbuf , 0 , hasRead);
                fos.flush();//将字节写入硬盘
            }
            fos.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
