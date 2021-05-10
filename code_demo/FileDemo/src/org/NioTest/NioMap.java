package org.NioTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.HashMap;
import java.util.Scanner;

public class NioMap {
    private File fileDir;
    private File file;
    private FileChannel outChannel = null;
    private ByteBuffer byteBuffer = null;
    private FileChannel inChannel = null;
    private ByteBuffer byteBuffer1 = null;
    private HashMap<String,String> mymap = new HashMap();

    public NioMap(String name) throws Exception {
        fileDir = new File("/home/wq/Nio");
        fileDir.mkdir();

        file = new File("/home/wq/Nio/"+name+".txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("文件创建成功!");
        }else{
            System.out.println("文件已存在!");
        }
    }



    public void WriteFile() throws Exception {
        System.out.println("输入K,V(exit结束)");
        Scanner sc1 = new Scanner(System.in);
        String write ;
        outChannel = new FileOutputStream(file,true).getChannel();//append为可以追加内容
        byteBuffer = ByteBuffer.allocate(128);
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("Key,Value\n");
        fileWriter.flush();
        fileWriter.close();
        while ((write = sc1.nextLine())!=null){
            if (write.equals("exit")){
                break;
            }
            write+="\n";
            byteBuffer.put(write.getBytes());
            byteBuffer.flip();//读模式
            while (byteBuffer.hasRemaining()) {
                outChannel.write(byteBuffer);
            }
            byteBuffer.clear();//写模式
        }
        System.out.println("写入完成!");
        System.out.println();
    }



    public void ReadFile() throws Exception {
        System.out.println("正在读取...");
        inChannel = new FileInputStream(file).getChannel();
        byteBuffer1 = ByteBuffer.allocate(128);
        String[] t=null;
        while ((inChannel.read(byteBuffer1))!=-1) {
            byteBuffer1.flip();//读模式


            Charset charset = Charset.forName("utf-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer1 = decoder.decode(byteBuffer1);


            String a= String.valueOf(charBuffer1);
            t = a.split("\n");
            byteBuffer1.clear();
        }

        for (int i = 0; i < t.length;i++) {
            String[] kv = t[i].split(",");
            String key = kv[0];
            String val = kv[1];
            if (!key.equals("Key") && !val.equals("Value")) {
                System.out.println("Key:" + key + "  Value:" + val);
                mymap.put(key, val);
            }
        }
        System.out.println(mymap);
        System.out.println("读取完成\n");
        System.out.println("请输入你想要查询的内容:");
        Scanner sc = new Scanner(System.in);
        String key = null;
        while ((key = sc.nextLine())!=null){
            if(key.equals("exit")){
                break;
            }
            if(mymap.containsKey(key)){
                String value = mymap.get(key);
                System.out.println("Value = "+value);
            }else {
                System.out.println("所查询Key值不存在");
            }
        }

    }

    public void CloseAll() throws Exception {
         outChannel.close();
         inChannel.close();
    }
}
