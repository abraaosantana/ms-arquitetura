package br.com.devweb.gateway.core.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator rotas(RouteLocatorBuilder builder) {
        return builder.routes()
        		
                .route("rh-ms-usuario", r -> r.path("/usuario/**")
                        .filters(f -> f
                        		.circuitBreaker(c -> c.setName("usuario-service")
                        		.setFallbackUri("forward:/fallback/usuarios"))
                        )
                        .uri("lb://rh-ms-usuario")
                )
                .build();
    }

}
