package br.com.devweb.pagamento.core.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBaseConfig {

	@Bean
	public RestTemplate restTemplateInstance() {
		return new RestTemplate();
	}

}
