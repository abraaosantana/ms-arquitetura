package br.com.devweb.configserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

@EnableConfigServer
@SpringBootApplication
public class RhConfigServerApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(RhConfigServerApplication.class);

	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(RhConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String username = env.getProperty("spring.cloud.config.server.git.username");
		String password = env.getProperty("spring.cloud.config.server.git.password");
		
		if (!username.isBlank() || !password.isBlank()) {
			LOG.info("GITHUB_USER: {} GITHUB_PASS: {}", username, password);
		} else {
			LOG.info("Configurar variáveis de ambiente: GITHUB_USER e GITHUB_PASS");
		}

	}

}
