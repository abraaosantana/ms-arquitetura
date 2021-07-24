package br.com.devweb.colaborador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RhMsColaboradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhMsColaboradorApplication.class, args);
	}

}
