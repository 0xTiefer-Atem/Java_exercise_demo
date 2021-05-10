package org2.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-12 下午1:16
 */
public class Send {
    private Socket socket;
    public Send(String ip,int port) throws IOException {
        socket = new Socket(ip,port);
    }

    public String sendMess(String mess) throws IOException {
        PrintWriter prt = new PrintWriter(socket.getOutputStream());
        prt.println(mess);
        prt.flush();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result  = bfr.readLine();
        System.out.println(result);
        return result;
    }
}
