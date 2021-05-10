package Nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

public class NioTest {
    public static void main(String[] args) throws Exception {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        FileChannel outChannel = new FileOutputStream("/home/wq/qwerty.txt",true).getChannel();
        Scanner sc = new Scanner(System.in);
        String line ;
        while ((line = sc.nextLine()) != null){
            if(line.equals("exit")){
                break;
            }
            line = line+"\n";
            byteBuffer.put(line.getBytes());
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                outChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }


        FileChannel inChannel = new FileInputStream("/home/wq/qwerty.txt").getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2048);
        String s = null ;
        while ((inChannel.read(byteBuffer1)) != -1) {
            byteBuffer1.flip();//转换为读模式
            Charset charset = Charset.forName("utf-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer1 = decoder.decode(byteBuffer1);
            s = String.valueOf(charBuffer1);
//            String[] temp = s.split("\n");
//            for(String stemp : temp){
//                System.out.println(stemp);
//            }
            System.out.println(s);
            byteBuffer1.clear();
        }
        String[] temp = s.split(",");
        for(String a :temp){
            System.out.println(a);
        }
        inChannel.close();
        outChannel.close();
    }
}
