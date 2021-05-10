package com.imooc.netty.websocket.dao;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class MyServerChannel {
    private String serverId;
    private Channel server_channel;
    private String condition;

    public MyServerChannel(){}

    public MyServerChannel(ChannelHandlerContext ctx){
        this.serverId = ctx.channel().id().toString();
        this.server_channel = ctx.channel();
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public Channel getServer_channel() {
        return server_channel;
    }

    public void setServer_channel(Channel server_channel) {
        this.server_channel = server_channel;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "MyServerChannel{" +
                "serverId='" + serverId + '\'' +
                ", server_channel=" + server_channel +
                ", condition='" + condition + '\'' +
                '}';
    }
}
