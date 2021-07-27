package br.com.devweb.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RhMsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhMsUserApplication.class, args);
	}

}
