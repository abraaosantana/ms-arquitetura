package br.com.devweb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RhGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhGatewayApplication.class, args);
	}

}
