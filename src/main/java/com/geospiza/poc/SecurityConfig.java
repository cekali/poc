package com.geospiza.poc;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@EnableWebSecurity (debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value(value = "${auth0.clientId}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterAfter(new CustomFilter(), FilterSecurityInterceptor.class).cors();
//        http.cors();

        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
//                .authorizeRequests().anyRequest().authenticated();
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/graphiql", "/h2-console/**", "/graphql/**", "/api")
        ;
    }
}
