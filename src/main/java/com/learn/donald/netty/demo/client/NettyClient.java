package com.learn.donald.netty.demo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import com.learn.donald.netty.demo.handler.NettyClientChildHandler;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/2 11:30
 * @Desc:
 */
@Slf4j
public class NettyClient {

    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientChildHandler());
                        }
                    });
            log.info("客户端 OK...");

            ChannelFuture sync = bootstrap.connect("127.0.0.1", 8888).sync();
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
