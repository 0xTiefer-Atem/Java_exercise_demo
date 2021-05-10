package org2.framework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-12 下午1:41
 */
public class Server {
    private int port;
    private ServerSocket ss ;
    public Server(int potr1) throws IOException {
        this.port = potr1;
        ss = new ServerSocket(port);
    }


    public void startServer(IDoSthInf ido){

        while(true){
            try {
                Socket s =ss.accept();
                DoSthRunn dsr = new DoSthRunn();
                dsr.setSocket(s);
                dsr.setIdosth(ido);

                Thread t = new Thread(dsr);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
