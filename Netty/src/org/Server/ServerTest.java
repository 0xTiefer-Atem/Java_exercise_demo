package org.Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Author:WangQian
 * Date:18-6-5
 */

class Server {
    public void accept(int bindport) throws InterruptedException {
        EventLoopGroup servergroup = new NioEventLoopGroup();
        EventLoopGroup clientgroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(servergroup, clientgroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new OutBoundHandler1());
                            channel.pipeline().addLast(new InBoundHandler1());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 30).
                    childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture chf = server.bind(bindport).sync();

            chf.channel().closeFuture().sync();
        }finally {
            servergroup.shutdownGracefully();
            clientgroup.shutdownGracefully();
        }
    }
}



public class ServerTest {
    public static void main(String[] args) throws InterruptedException {
        Server server = new Server();
        server.accept(9999);
    }
}
