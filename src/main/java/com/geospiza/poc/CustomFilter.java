package com.geospiza.poc;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class CustomFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String header = ((HttpServletRequest)request).getHeader("Authorization");

        if(null == header) {
            ThreadLocalStorage.setTenantName("basic");
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace("Bearer", "");

        DecodedJWT jwt = JWT.decode(token);

        String org = jwt.getClaim("https://app.geospiza.us/app_metadata").asMap().get("organization").toString();

        ThreadLocalStorage.setTenantName(org);

        chain.doFilter(request, response);
    }
}
