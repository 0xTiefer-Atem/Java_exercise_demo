package org.Server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public class InBoundHandler1 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandler1.channelRead:  " +ctx);
        ByteBuf mess = (ByteBuf) msg;
        byte[] bytes = new byte[mess.readableBytes()];
        mess.readBytes(bytes);
        String result = new String(bytes);
        System.out.println("来自客户端:" + result);
        mess.release();
        ctx.write(result);
        ctx.flush();
    }
}
