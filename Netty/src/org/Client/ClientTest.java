package org.Client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Author:WangQian
 * Date:18-6-5
 */

class Client{
    public void connection(String ip,int port) throws Exception{
        EventLoopGroup event = new NioEventLoopGroup();
        try {

            Bootstrap boot = new Bootstrap();
            boot.group(event);
            boot.channel(NioSocketChannel.class);
            boot.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline().addLast(new ClientHandler());
                }
            }).option(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture chf = boot.connect(ip, port);
            chf.channel().closeFuture().sync();
        }finally {
            event.shutdownGracefully();
        }
    }
}



public class ClientTest {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.connection("127.0.0.1",9999);
    }
}
