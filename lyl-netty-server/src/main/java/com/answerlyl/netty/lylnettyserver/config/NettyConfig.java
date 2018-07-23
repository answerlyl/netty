package com.answerlyl.netty.lylnettyserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取yml配置文件中的信息
 */
@Component
@ConfigurationProperties(prefix = "netty")
public class NettyConfig {

    private int port;

    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
