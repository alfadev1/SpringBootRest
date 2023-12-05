package com.alfadev1APIREST.SpringBootRest.context;

/**
 *
 * @author cyka
 */
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

@EnableSwagger2
public class SwaggerConfig { 
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alfadev1APIREST.SpringBootRest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
                
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "SpringBoot API",
                "Practica de APIrest-SpringBoot",
                "v1",
                "termsOfService",
                new Contact("alfadev1", "https://github.com/alfadev1", "alfarollano@gmail.com"), 
                "Licencia de API",
                "ejemploLicenciaUrl", 
                Collections.emptyList());
    }
}
