package org2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlieInputStreamTest {
    public static void main(String[] args) throws IOException
    {
//        File f=new File("/home/wq/oo.txt");
//        f.createNewFile();
        InputStream fis = new FileInputStream("/home/wq/FileOutputStream/text.txt");//从目标文件往控制台读
        byte[] bbuf = new byte[100];
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0 )
        {
            System.out.print(new String(bbuf , 0 , hasRead));
            //System.out.println(bbuf.length);
            System.out.println("---------------------------------------------------------");

        }
        fis.close();//关闭fid
    }
}
