package org.framework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public class Server {
    private int bindport = 0;
    private ServerSocket ss;

    public Server(int port) throws IOException {
        this.bindport = port;
        ss = new ServerSocket(this.bindport);
    }


    public void dosths(IDoInf idosth) throws Exception {
        while (true) {
            Socket socket = ss.accept();
            ServerThread sthread = new ServerThread();
            sthread.setSocket(socket);
            sthread.setDoSth(idosth);
            Thread serthread = new Thread(sthread);
            serthread.start();
        }
    }
}
