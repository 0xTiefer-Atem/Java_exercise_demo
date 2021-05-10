package org.Server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Author:WangQian
 * Date:18-6-6
 */
public class OutBoundHandler1 extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println(msg+"==============");
//        ByteBuf mess1 = (ByteBuf) msg;
//        byte[] bytes = new byte[mess1.readableBytes()];
//        mess1.readBytes(bytes);
//        String result = new String(bytes);
//        System.out.println("============" + result);

        System.out.println("OutBoundHandler1 传回给服务器");
        String mess = "i am server";
        ByteBuf byteBuf = ctx.alloc().buffer(4*mess.length());
        byteBuf.writeBytes(mess.getBytes());
        ctx.write(byteBuf);
        ctx.flush();
    }
}
