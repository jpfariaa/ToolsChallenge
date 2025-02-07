package com.br.ToolsChallenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Pagamentos")
                        .description("API para operações de pagamento, estorno e consulta")
                        .version("1.0")
                        .termsOfService("Termos de Serviço")
                        .contact(new Contact().name("João Pedro Faria de Almeida").email("jpalmeida.faria@gmail.com")));
    }
}
