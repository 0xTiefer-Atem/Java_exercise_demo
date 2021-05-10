package com.imooc.netty.websocket.dao;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class MyClientChannel {
    private String clientId;
    private Channel client_channel;
    private String condition;

    public MyClientChannel(){}

    public MyClientChannel(ChannelHandlerContext ctx){
        this.clientId = ctx.channel().id().toString();
        this.client_channel = ctx.channel();
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Channel getChannel() {
        return client_channel;
    }

    public void setChannel(Channel channel) {
        this.client_channel = channel;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "MyClientChannel{" +
                "clientId='" + clientId + '\'' +
                ", channel=" + client_channel +
                ", condition='" + condition + '\'' +
                '}';
    }
}
