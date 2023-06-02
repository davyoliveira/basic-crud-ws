package com.softplan.crudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaAuditing ( auditorAwareRef = "auditingService" )
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

    @Bean
    public WebMvcConfigurer corsConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings ( CorsRegistry registry ) {
                registry.addMapping( "/**" ).allowedOrigins( "http://localhost:8080" );
            }
        };
    }

    // @Bean
    // public WebMvcConfigurer corsMappingConfigurer () {
    // return new WebMvcConfigurer() {
    // @Override
    // public void addCorsMappings ( CorsRegistry registry ) {
    // WebConfigProperties.Cors cors = webConfigProperties.getCors();
    // registry.addMapping( "/**" ).allowedOrigins( cors.getAllowedOrigins()
    // ).allowedMethods( cors.getAllowedMethods() ).maxAge( cors.getMaxAge()
    // ).allowedHeaders( cors.getAllowedHeaders() )
    // .exposedHeaders( cors.getExposedHeaders() );
    // }
    // };
    // }

}
