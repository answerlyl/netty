package com.answerlyl.netty.lylnettyclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取yml配置文件中的信息
 */
@Component
public class NettyConfig {
    private static int port;
    private static String host;

    @Value("${netty.port}")
    public void setPort(int port) {
        NettyConfig.port = port;
    }

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }

    @Value("${netty.host}")
    public void setHost(String host) {
        NettyConfig.host = host;
    }
}
