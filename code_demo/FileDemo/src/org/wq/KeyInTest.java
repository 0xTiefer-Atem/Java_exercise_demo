package org.wq;

import java.io.*;

public class KeyInTest {
    public static void main(String[] args) throws Exception {
        File f = new File("/home/wq/File");
        f.mkdir();
        File file = new File("/home/wq/File/123.txt");
        FileWriter fileWriter = new FileWriter(file);
        InputStreamReader reader = new InputStreamReader(System.in);//设备流,从控制台读
        BufferedReader br = new BufferedReader(reader);//读缓冲
        String line = null;
        System.out.println("不停打印,exit结束");
        while ((line = br.readLine()) != null)
        {
            if (line.equals("exit"))
            {
                System.exit(1);
            }
            fileWriter.write(line+"\n");
            fileWriter.flush();
            System.out.println("输入内容为:" + line);
        }
        fileWriter.close();
        br.close();
        reader.close();
    }
}
