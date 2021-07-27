package br.com.devweb.usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class RhMsUsuarioApplication implements CommandLineRunner{
	
	private static Logger LOG = LoggerFactory.getLogger(RhMsUsuarioApplication.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoderBCrypt;
	
	public static void main(String[] args) {
		SpringApplication.run(RhMsUsuarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String valor = "123456";
		LOG.info("ORIGEM: [{}] BCRYPT: [{}]", valor, passwordEncoderBCrypt.encode(valor));
	}

}
