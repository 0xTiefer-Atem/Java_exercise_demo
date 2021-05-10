package org1.CodePro;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Author:WangQian
 * Date:18-6-7 下午11:05
 */

public class CodeProducer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("/home/wq/JsonJava");
        if (!f.exists()) {
            f.mkdir();
        }

        File file = new File("/home/wq/json.txt");
        FileChannel fc = new FileInputStream(file).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer = null;
        while (fc.read(byteBuffer) != -1) {
            byteBuffer.flip();
            Charset charset = Charset.forName("utf-8");
            CharsetDecoder decoder = charset.newDecoder();
            charBuffer = decoder.decode(byteBuffer);
            byteBuffer.clear();
        }
        String s = String.valueOf(charBuffer);
        System.out.println("读取到的json");
        System.out.println(s);
        System.out.println();
        AnalyJson analyJson = new AnalyJson();
        String res = analyJson.splitjson(s);
        System.out.println("解析之后的json");
        System.out.println(res);
        System.out.println();

        String[] tempres = res.split(",");
        for (int i = 0; i < tempres.length; i++) {
            if (tempres[i].contains("methods")) {
                String[] temps = tempres[i].split(":");
                tempres[i] = temps[1] + ":" + temps[2];
            }
        }
        CreateJava createjava = new CreateJava(tempres, f);
        String javapath = createjava.createJava();

        CreateClass createClass = new CreateClass();
        Class clazz = createClass.loadClass(javapath);
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(clazz.getName());
        System.out.println("该类的方法");
        for (Method m : methods) {
            System.out.println(m.getName()+" "+m.getReturnType());
        }


    }
}

