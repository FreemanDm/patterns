package com.freeman.patterns;

import lombok.SneakyThrows;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication {

	@SneakyThrows
	public static void main(String[] args) {
//		Server webServer = Server.createWebServer("-web,-webAllowOthers,true,-webPort,8082").start();
//		Server server = Server.createTcpServer("-tcp,-tcpAllowOthers,true,-tcpPort,9092").start();
		SpringApplication.run(PatternsApplication.class, args);

	}
}
