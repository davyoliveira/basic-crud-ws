package com.softplan.crudapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf( csrf -> csrf.disable() );
        http.authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource () {
        CorsConfiguration configuration = new CorsConfiguration();
        // configuration.setAllowedOrigins( Arrays.asList(
        // "http://localhost:8080" ) );
        configuration.addAllowedHeader( "*" );
        configuration.addAllowedOrigin( "*" );
        configuration.addAllowedMethod( HttpMethod.GET.name() );
        configuration.addAllowedMethod( HttpMethod.POST.name() );
        configuration.addAllowedMethod( HttpMethod.PUT.name() );
        configuration.addAllowedMethod( HttpMethod.DELETE.name() );
        configuration.addExposedHeader( "*" );
        // configuration.setAllowedMethods( Arrays.asList( "GET" , "POST" ,
        // "PUT" , "DELETE" , "OPTIONS" ) );
        // configuration.setAllowCredentials( true );
        // configuration.setAllowedHeaders( Arrays.asList( "Authorization" ,
        // "Requestor-Type" ) );
        org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration( "/**" , configuration );
        return source;
    }

}

