package com.bwgjoseph.springbootmvc.logging;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {
    // before handler is called
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // log out request
        log.info("[interceptor] preHandle: {} {} {}", request, response, handler);
		return true;
	}

    // after handler process, but before view is rendered
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("[interceptor] postHandle: {} {} {}", request, response, handler);
	}

    // after view is rendered
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("[interceptor] afterCompletion: {} {} {}", request, response, handler);
    }
}
