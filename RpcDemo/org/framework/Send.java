package org.framework;

import java.io.*;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-5
 */
public class Send {

    private String ip = null;
    private int port = 0;
    private Socket socket = null;

    public Send(String ip1,int port1){
        this.ip = ip1;
        this.port = port1;
    }

    public void sendmessage(String line) throws IOException {
        socket = new Socket(ip,port);
        PrintWriter pwt = new PrintWriter(socket.getOutputStream());
        System.out.println("发送信息:" + line);
        pwt.println(line);
        pwt.flush();
        System.out.println("发送成功");

    }

    public String receive() throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String buffer = bfr.readLine();
        System.out.println("Send.receive "+buffer);

        return buffer;
    }
}
