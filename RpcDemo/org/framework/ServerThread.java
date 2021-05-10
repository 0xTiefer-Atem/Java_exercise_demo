package org.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public class ServerThread implements Runnable {
    private Socket socket;
    private IDoInf ido = null;

    public void setSocket(Socket s) {
        this.socket = s;
    }

    public void setDoSth(IDoInf dosth) {
        this.ido = dosth;
    }

    @Override
    public void run() {
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bfr.readLine();
            System.out.println("服务端读取到的信息:" + message);
            String[] classmess = message.split("\\|");

            for (String temp: classmess) {
                System.out.println(temp);
            }

            String method = classmess[1];
            Method[] methods = ido.getClass().getDeclaredMethods();
            String res = null;
            for (int i = 0; i < methods.length; i++) {

                String name = methods[i].getName();
                System.out.println(name);
                if (name.equals(method)) {
                    res = ido.dosth(methods[i], message);
                }
            }

            System.out.println("ServerThread.run  "+res);
            PrintWriter prt = new PrintWriter(socket.getOutputStream());
            System.out.println(res);
            prt.println(res);
            prt.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
