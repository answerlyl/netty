package com.answerlyl.netty.lylnettyserver;

import com.answerlyl.netty.lylnettyserver.start.NettyServerBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LylNettyServerApplication implements CommandLineRunner{

	@Autowired
	private NettyServerBootstrap nettyServerBootstrap;

	public static void main(String[] args) {
		SpringApplication.run(LylNettyServerApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		nettyServerBootstrap.start();

	}
}
