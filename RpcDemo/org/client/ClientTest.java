package org.client;

import org.framework.Client;

import java.io.IOException;

/**
 * Author:WangQian
 * Date:18-6-4
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        //client.logIn("localhost",9999,"aaa","bbb");
        System.out.println(Client.class);

    }
}
