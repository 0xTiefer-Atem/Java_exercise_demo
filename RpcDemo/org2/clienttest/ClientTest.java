package org2.clienttest;

import org2.framework.Client;

import java.io.IOException;

/**
 * Author:WangQian
 * Date:18-6-11 下午7:40
 */
public class ClientTest {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.logIn1("localhost",9999,"aaa","bbb");
    }
}
