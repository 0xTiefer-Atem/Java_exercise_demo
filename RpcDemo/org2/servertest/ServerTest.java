package org2.servertest;

import org2.framework.Server;

import java.io.IOException;

/**
 * Author:WangQian
 * Date:18-6-11 下午7:40
 */
public class ServerTest {
    public static void main(String[] args) {
        try {
            Server server = new Server(9999);
            LogIn logIn = new LogIn();
            server.startServer(logIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
