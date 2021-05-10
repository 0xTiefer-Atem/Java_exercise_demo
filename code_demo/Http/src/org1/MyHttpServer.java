package org1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import com.sun.net.httpserver.*;
import com.sun.net.httpserver.HttpServer;

public class MyHttpServer {

    public static void main(String[] args) {
        try {
            HttpServer httpServer=HttpServer.create(new InetSocketAddress(7777),10);
            httpServer.createContext("/",new MyHandler());
//            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     static class MyHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println(httpExchange.getRequestURI().toString());
            String html="<html><h3>hello!</h3><html>";

            Headers headers = httpExchange.getResponseHeaders();
            headers.set("Content-Type","first/html;charset=utf-8");

            FileInputStream filein = new FileInputStream("/home/wq/first.html");
            FileChannel fileChannel = filein.getChannel();
            Charset charset = Charset.forName("utf-8");

            OutputStream out=httpExchange.getResponseBody();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while((fileChannel.read(byteBuffer)) != -1){
                byteBuffer.flip();
                httpExchange.sendResponseHeaders(200,90100);

                CharsetDecoder decoder =charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(byteBuffer);

                System.out.println(charBuffer);
                String temp = String.valueOf(charBuffer);
                out.write(temp.getBytes());
                out.flush();
            }
            out.close();
        }
    }
}