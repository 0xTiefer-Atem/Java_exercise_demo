package org3;

import java.io.*;

public class RadomWrite {
    public static void main(String[] args) throws Exception {
        System.out.println("随机文件写测试");
        FileOutputStream fpt = new FileOutputStream("/home/wq/studen1.xml",true);
        PrintStream ps = new PrintStream(fpt);
        System.setOut(ps);
        String string = "";
        InputStreamReader imreader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(imreader);
        while((string = br.readLine())!=null){
            if(string.equals("exit")){
                break;
            }
            System.out.println(string);
        }
        br.close();
        imreader.close();
        ps.close();
        fpt.close();
    }
}
