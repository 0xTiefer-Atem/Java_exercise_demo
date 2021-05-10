package org.test;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestX {
    public void port(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            BufferedReader reader;
            Socket socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
//            while ((line = reader.readLine()) != null && !line.isEmpty()) {
//                System.out.println(line);
//            }
            OutputStream out = socket.getOutputStream();
            out.write("HTTP/1.1 200 OK".getBytes());
            out.write("Content-Type: charset=UTF-8".getBytes());
            out.write("Content-type:text/html".getBytes());
            out.write("王骞".getBytes());
            out.flush();
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        TestX testX = new TestX();
        testX.port(9999);
    }
}
