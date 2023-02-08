package com.sghc.ecommerce.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Value("${allowed.origin}")
    private String allowedOrigin;
	
	@Bean
	public WebMvcConfigurer getCorsConfiguration() {
		 return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        //.allowedOriginPatterns(allowedOrigin)
	                        .allowedMethods("GET", "POST", "PUT", "DELETE")
	                        .allowedHeaders("*")
	                        .allowedOriginPatterns("*")
	                        .allowCredentials(false).maxAge(3600);
	            }
	        };
	}
}
