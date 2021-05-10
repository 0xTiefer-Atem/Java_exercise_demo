package org2.framework;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import static java.text.DateFormat.LONG;

/**
 * Author:WangQian
 * Date:18-6-11 下午7:53
 */
public class Client {
    private Date date;
    public void logIn(String ip,int port,String name,String pass) throws IOException {
        Send send = new Send(ip,port);
        send.sendMess("logIn|"+name+"|"+pass);
    }
    public void logIn1(String ip,int port,String name,String pass) throws IOException {
        Send send = new Send(ip,port);
        date = new Date();
        String day = DateFormat.getDateInstance(LONG).format(date);
        send.sendMess("logIn1|"+name+"|"+pass+"|"+day);
    }
}
