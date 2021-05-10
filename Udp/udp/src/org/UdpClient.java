package org;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Author:WangQian
 * Date: 18-7-14 下午10:27
 */
public class UdpClient {
    private static int BIND_PORT = 6666;
    private static String BIND_IP = "255.255.255.255";
    private static  int DATA_LEN = 4096;
    byte[] inbuff = new byte[DATA_LEN];
    private DatagramPacket in_DatagramPacket = new DatagramPacket(inbuff,inbuff.length);
    private DatagramPacket out_DatagramPacet = null;

    public void send_receive(){
        try {
            DatagramSocket clientsocket = new DatagramSocket();
            out_DatagramPacet = new DatagramPacket(new byte[0],0,InetAddress.getByName(BIND_IP),BIND_PORT);
            Scanner sc = new Scanner(System.in);
            String mess = null;
            while ((mess = sc.nextLine())!=null){
                byte[] bytes = mess.getBytes();
                out_DatagramPacet.setData(bytes);
                clientsocket.send(out_DatagramPacet);
                clientsocket.receive(in_DatagramPacket);
                System.out.println(new String(inbuff,0,in_DatagramPacket.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UdpClient().send_receive();
    }
}
