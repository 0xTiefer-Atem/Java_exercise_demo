package Nio;

import sun.nio.cs.ext.DoubleByte;

import java.io.File;
import java.io.FileInputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class NioTest1 {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/wq/qwerty.txt");
        if(file == null){
            file.createNewFile();
        }
        FileChannel inChannl = new FileInputStream(file).getChannel();
        MappedByteBuffer mappedByteBuffer = inChannl.map(FileChannel.MapMode.READ_ONLY,0,file.length());
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer = decoder.decode(mappedByteBuffer);
        String s = String.valueOf(charBuffer);
        String[] a = s.split(" ");
        for(String t:a){
            System.out.print(t);
        }

        //System.out.println(s);
    }
}
