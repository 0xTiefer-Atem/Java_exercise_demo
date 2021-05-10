package org.wq;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-2
 */
public class PortMap {
    public static void main(String[] args) throws Exception {
        int port = 9999;
        ServerSocket ss = new ServerSocket(port);//开指定端口
        String address = "music.163.com";
        String line = "\r\n";
        StringBuffer response = new StringBuffer();
        StringBuffer requestheader = new StringBuffer();
        requestheader.append("GET / HTTP/1.1" + line);
        requestheader.append("Host: " + address + line);
        requestheader.append("Accept-Charset: UTF-8" + line);
        requestheader.append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + line);
        requestheader.append("Accept-Language: zh-CN,zh;q=0.8" + line);
        requestheader.append("User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.92 Safari/537.36" + line);
        requestheader.append("Connection: keep-alive "+line);
//        requestheader.append("Content-Security-Policy: upgrade-insecure-requests"+line);
//        requestheader.append("Referer: https://music.163.com/link?url=tFTsFSEdhqoa37pnj4dg1t9ATyDhYJ_tk2e2uCN0jR7&wd=&eqid=c9500ac2000452b5000000035b9de086"+line+line);
//        requestheader.append("Cookie: _ntes_nnid=410645e9a969080af3e47aa90a703f9f,1535000606953; _ntes_nuid=410645e9a969080af3e47aa90a703f9f; P_INFO=m15810227076@163.com|1535003467|1|mail163|00&99|tij&1534948575&mail163#tij&null#10#0#0|158076&1|kaola&mail163|15810227076@163.com; nts_mail_user=15810227076@163.com:-1:1; mail_psc_fingerprint=ffd6d82edfebf87f7be70018ef14dbfa; _iuqxldmzr_=32; WM_TID=FzaFAnIWCuxMxbjXDplFZpE3avI%2FX5DF; JSESSIONID-WYYY=Jn%2FWtsI7Bs6BjdaQvJdtSOGwpWTfoT5vVUoRlDdkFKm0eXTRAQQk8HmZ26vK4uPNP5jdHo%5CbySUwCMxDKmaBBM7FMu%2B6RtMrWhziDOdTQYNbhppBksjFlV4uXZnT3Rlp%5CxDkO4nocpJW5KXBk82S8K0pWxbWI%2FZXQHmQPsOCdrs2NGAj%3A1537075097702; __utmc=94650624; __utma=94650624.1407630914.1537073299.1537073299.1537073299.2; __utmz=94650624.1537073299.2.2.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; WM_NI=xUdHFjNtAeB8zRo16Xj3SCUI1Hl09tgXOHWy43qGc5zexJs3y9E0mtamqdXVSAiYH4%2FrLxeUAg%2BN5w5dva10hhqoLqZOtpOqHZVNFYsKX6%2FvMt7poFhknqPLlGzyqS6sWm4%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6ee84b333968788b0f980e9a997d0c468ae99a88dcd7c9aabb9b7c249a7eafd82c92af0fea7c3b92abc8baca9c5628eac8f86c134ba8ea1d2b554aaed9da4d843f398a4d1bc80a58881a9d673f8edbfa8e23fbabbb8abf239bbe78bd1f080a3b3bf85db5e919fa7bacb40edae8499e85f83b9e5afb87df7bcba82b43cacb8bf90cf7b9a91bc91ce7b8c869aafc553b19598d7ae7e8facf991ee4eacb5a292d348b099b69af459f6ad998eb737e2a3; __utmb=94650624.11.10.1537073299"+line);
        requestheader.append("Upgrade-Insecure-Requests: 1"+line+line);

        Socket broswer = ss.accept();

        System.out.println("收到请求");
        Socket baiduclient = new Socket(address, 80);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(broswer.getInputStream(), "utf-8"));

        PrintStream prt = new PrintStream(baiduclient.getOutputStream());
        String message;
//        if ((message = bfr.readLine() )!= null){
//            System.out.println(message+"   --------------------");
//            if(!message.equals("null")){
//                if(message.contains("Host")){
//                    prt.println("Host: "+address+line);
//                    prt.flush();
//                }else {
//                    prt.println(message+line);
//                    prt.flush();
//                }
//            }
//        }
        prt.println(requestheader.toString().getBytes("utf-8"));
        prt.flush();

        System.out.println("=======================");

//        System.out.println("正在请求百度...\n");
        System.out.println("请求成功\n");

        BufferedReader bdbfr = new BufferedReader(new InputStreamReader(baiduclient.getInputStream()));
        String content;

        OutputStream out = broswer.getOutputStream();
        while ((content = bdbfr.readLine()) != null) {
            if (content.equals("</body></html>")){
                response.append(content);
                break;
            }else {
                response.append(content+"\n");
            }
        }

        System.out.println("-=-=-=-=-=-=");
        String[] response_contents = response.toString().split("X-Ua-Compatible: IE=Edge,chrome=1");
        System.out.println(response.indexOf("<!DOCTYPE html><!--STATUS OK-->"));

        System.out.println(response.toString());
//        out.write("HTTP/1.1 200 OK \r\n".getBytes());
//        out.write(response_contents[1].getBytes("utf-8"));
//        out.flush();
        prt.close();
        out.close();
        bfr.close();
        bdbfr.close();
        broswer.close();
        ss.close();
    }
}
