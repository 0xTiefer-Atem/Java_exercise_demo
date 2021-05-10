package org1.wq;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-5-31
 */
class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String address = "www.baidu.com";
        String line = "\r\n";
        System.out.println("收到请求");
        StringBuffer requestheader = new StringBuffer();
        requestheader.append("GET / HTTP/1.1" + line);
        requestheader.append("Host: " + address + line + line);
        requestheader.append("Accept-Charset: UTF-8" + line);
        requestheader.append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + line);
        requestheader.append("Accept-Language: zh-CN,zh;q=0.8" + line);
        requestheader.append("User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36" + line);

        System.out.println(requestheader.toString());
        Socket s = new Socket("localhost", 8089);
        OutputStream out = s.getOutputStream();
        System.out.println("11111111111111");
        out.write(requestheader.toString().getBytes());
        out.flush();
        System.out.println("2222222222222222222");


        StringBuffer message = new StringBuffer();
        BufferedReader bfr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String tempmess;
        while ((tempmess = bfr.readLine()) != null) {
            if (tempmess.contains("Content-Type")) {
                tempmess += ",UTF-8";
                //System.out.println(tempmess);
                message.append(tempmess);
            } else {
                //System.out.println(tempmess);
                message.append(tempmess);
            }
        }


        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, message.toString().getBytes().length);
        Headers respons = httpExchange.getResponseHeaders();
        System.out.println(respons.keySet());
        OutputStream responseBody = httpExchange.getResponseBody();
        OutputStream writer = responseBody;
        System.out.println();
        writer.write(message.toString().getBytes());
        writer.close();
        responseBody.close();
        s.close();
    }
}


public class MyHttpServer {
    public static void main(String[] args) throws Exception {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8088),1);
        httpServer.createContext("/",new MyHttpHandler());
        httpServer.start();
    }
}
