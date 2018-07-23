package com.answerlyl.netty.lylnettyclient.start;

import com.answerlyl.netty.lylnettyclient.config.NettyConfig;
import com.answerlyl.netty.lylnettyclient.handler.NettyClientHandler;
import com.answerlyl.netty.lylnettyutils.bean.AskMsg;
import com.answerlyl.netty.lylnettyutils.bean.AskParams;
import com.answerlyl.netty.lylnettyutils.bean.LoginMsg;
import com.answerlyl.netty.lylnettyutils.constant.Constants;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class NettyClientBootstrap {
    private SocketChannel socketChannel;
    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);

    public void start() {
        EventLoopGroup eventLoopGroup=new NioEventLoopGroup();
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(NettyConfig.getHost(),NettyConfig.getPort());
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new IdleStateHandler(20,10,0));
                socketChannel.pipeline().addLast(new ObjectEncoder());
                socketChannel.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                socketChannel.pipeline().addLast(new NettyClientHandler());
            }
        });
        try{
            ChannelFuture future =bootstrap.connect(NettyConfig.getHost(),NettyConfig.getPort()).sync();
            if (future.isSuccess()) {
                socketChannel = (SocketChannel)future.channel();
                System.out.println("connect server  成功");
            }
        }catch (InterruptedException e){

        }

    }
    public static void main(String[]args) throws InterruptedException {

        NettyClientBootstrap bootstrap=null;//new NettyClientBootstrap(21992,"localhost");

        Constants.setClientId("001");
        LoginMsg loginMsg=new LoginMsg();
        loginMsg.setPassword("yao");
        loginMsg.setUserName("robin");
        bootstrap.socketChannel.writeAndFlush(loginMsg);
        while (true){
            TimeUnit.SECONDS.sleep(3);
            AskMsg askMsg=new AskMsg();
            AskParams askParams=new AskParams();
            askParams.setAuth("authToken");
            askMsg.setParams(askParams);
            bootstrap.socketChannel.writeAndFlush(askMsg);
        }
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }
}
