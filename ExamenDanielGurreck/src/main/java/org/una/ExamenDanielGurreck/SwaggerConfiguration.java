package org.una.ExamenDanielGurreck;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.ExamenDanielGurreck.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Membresias", "Entidad de Membresias"),
                        new Tag("Clientes", "Entidad de Clientes"),
                            new Tag("Cobros Pendientes", "Entidad de Cobros Pendientes"),
                                new Tag("Tipos Servicios", "Entidad de Tipos Servicios"),
                                    new Tag("Clientes Tipos Servicios", "Entidad de Clientes Tipos Servicios")

                );

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Examen Final",
                "Rest API del requerimiento 7.3.",
                "Versión:2.1.0",
                "https://google.com",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}