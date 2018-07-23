package com.answerlyl.netty.lylnettyclient;

import com.answerlyl.netty.lylnettyclient.start.NettyClientBootstrap;
import com.answerlyl.netty.lylnettyutils.bean.AskMsg;
import com.answerlyl.netty.lylnettyutils.bean.AskParams;
import com.answerlyl.netty.lylnettyutils.bean.LoginMsg;
import com.answerlyl.netty.lylnettyutils.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LylNettyClientApplication implements CommandLineRunner {

	@Autowired
	private NettyClientBootstrap nettyClientBootstrap;

	public static void main(String[] args) {
		SpringApplication.run(LylNettyClientApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		nettyClientBootstrap.start();
		Constants.setClientId("18201150091");
		LoginMsg loginMsg=new LoginMsg();
		loginMsg.setPassword("yao");
		loginMsg.setUserName("robin");
		nettyClientBootstrap.getSocketChannel().writeAndFlush(loginMsg);
	}
}


