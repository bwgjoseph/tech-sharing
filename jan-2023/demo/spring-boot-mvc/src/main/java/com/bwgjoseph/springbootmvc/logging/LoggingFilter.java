package com.bwgjoseph.springbootmvc.logging;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

// 1. Can specify @Order for all fitlers so it can run at a specific order
// 2. Filter can be define to target for a specific URL pattern via `FilterRegistrationBean`
// 3. There is a `OncePerRequestFilter` that only run once per request, in the event that it passes through multiple Servlets (e.g Spring Security)
@Slf4j
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // log out request
        log.info("[filter] Request: {}", request);
        // continue filter chain
        chain.doFilter(request, response);
        // log out response
        log.info("[filter] Response: {}", response);
    }
}
