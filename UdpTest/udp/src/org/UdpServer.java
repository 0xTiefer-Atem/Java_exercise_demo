package org;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Author:WangQian
 * Date: 18-7-14 下午10:28
 */
public class UdpServer {
    private static final int PORT = 6666;
    private static final int DATA_LEN = 4096;//定义每个数据报大小4K
    private byte[] inbytes = new byte[DATA_LEN];//定义接受网络数据字节数组

    //定义一个用于发送DatagramPacket对象
    private DatagramPacket in_DatagramPacket = new DatagramPacket(inbytes, inbytes.length);

    //定义一个用于发送的DatagramPacket的对象
    private DatagramPacket out_DatagramPacket = null;

    private String servermess = "i am server ";

    public void send() {
        try {
            DatagramSocket datasocket = new DatagramSocket(PORT);
            while (true) {
                datasocket.receive(in_DatagramPacket);
                System.out.println(inbytes == in_DatagramPacket.getData());
                System.out.println(new String(inbytes, 0, in_DatagramPacket.getLength()));
                byte[] outbytes = servermess.getBytes();
                out_DatagramPacket = new DatagramPacket(outbytes, outbytes.length, in_DatagramPacket.getSocketAddress());
                out_DatagramPacket.setData(outbytes);
                datasocket.send(out_DatagramPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UdpServer().send();
    }
}
