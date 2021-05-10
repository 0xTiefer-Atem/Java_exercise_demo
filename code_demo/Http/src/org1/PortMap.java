package org1;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Author:WangQian
 * Date:18-6-1
 */



public class PortMap {
    private Selector selector = null;//用于检测所有channel状态的selector

    private int port = 9999;//要绑定的端口

    private Charset charset = Charset.forName("utf-8");

    public void init() throws Exception {
        selector = Selector.open();//将selector开启

        ServerSocketChannel socketChannel = ServerSocketChannel.open();//开启一个ServerSocketChannel实例
        InetSocketAddress inet = new InetSocketAddress(port);//绑定端口


        socketChannel.accept().bind(inet);//将该socketChannel绑定到指定端口
        socketChannel.configureBlocking(false);//以非阻塞方式工作


        socketChannel.register(selector,SelectionKey.OP_ACCEPT);






    }


    public static void main(String[] args) throws Exception{


    }
}
