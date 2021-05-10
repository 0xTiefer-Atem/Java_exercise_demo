package org2.framework;
import org2.idl.MyDoSth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Author:WangQian
 * Date: 18-6-13 下午4:15
 */
public class DoSthRunn implements Runnable {

    private Socket socket;
    private IDoSthInf idosth;

    public IDoSthInf getIdosth() {
        return idosth;
    }

    public void setIdosth(IDoSthInf idosth) {
        this.idosth = idosth;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mess = bfr.readLine();
            System.out.println("mess   " + mess);
            String[] messages = mess.split("\\|");
            System.out.println(messages.length);
            System.out.println(idosth.getClass());
            Method[] methods = idosth.getClass().getMethods();

            Object b = null;
            for (int i = 0; i < messages.length - 1; i++) {
                System.out.println(methods[i].getName() + "  " + methods[i].getParameterCount());
                if (methods[i].getName().equals(messages[0])) {
                    try {
                        switch (methods[i].getParameterCount()) {
                            case 0:
                                System.out.println("case 0");
                                b = idosth.IDoSth0(methods[i], mess);
                                break;
                            case 1:
                                System.out.println("case 1");
                                b = idosth.IDoSth1(methods[i], mess);
                                break;
                            case 2:
                                System.out.println("case 2");
                                b = idosth.IDoSth2(methods[i], mess);
                                break;
                            case 3:
                                System.out.println("case 3");
                                b = idosth.IDoSth3(methods[i], mess);
                                break;
                        }
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            PrintStream prt = new PrintStream(socket.getOutputStream());
            prt.println(b);
            prt.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
