package br.com.cotiinformatica.apiusuariosfix.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8081");
        localServer.setDescription("Servidor Local");

        return new OpenAPI()
                .servers(List.of(localServer))
                .info(
                        new Info()
                                .title("API Usuários")
                                .description("API REST para gerenciamento de usuários")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Karmaicom Martins")
                                                .email("karmaicom@gmail.com")
                                )
                                .license(
                                        new License()
                                                .name("MIT")
                                                .url("https://opensource.org/licenses/MIT")
                                )
                );
    }

}
