package com.geospiza.poc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

/**
 * Created by craigkalick on 8/25/17.
 */
@Configuration
public class GlobalRepositoryRestConfig implements RepositoryRestConfigurer {

    private static final String ALLOWED_ORIGINS = "*";
    private static final String CORS_BASE_PATTERN = "/**";
    private static final String ALLOWED_METHODS = "*";
    private static final String ALLOWED_HEADERS = "*";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        config.getCorsRegistry()
                .addMapping(CORS_BASE_PATTERN)
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowedHeaders(ALLOWED_HEADERS)
                .allowedMethods(ALLOWED_METHODS)
        ;

        config.getCorsRegistry().addMapping("/layers").allowedOrigins("localhost:3000").allowedMethods(HttpMethod.OPTIONS.toString());
    }
}
