package org.Client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Author:WangQian
 * Date:18-6-5
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf respon = (ByteBuf)msg;
        byte[] result = new byte[respon.readableBytes()];
        respon.readBytes(result);
        respon.release();
        ctx.close();
        System.out.println("来自服务器:"+new String(result));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String mess = "This is Client";
        ByteBuf byteBuf = ctx.alloc().buffer(4*mess.length());
        byteBuf.writeBytes(mess.getBytes());
        ctx.write(byteBuf);
        ctx.flush();
    }
}
