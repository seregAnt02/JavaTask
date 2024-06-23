package com.gb.http.logging;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("request {}", httpServletRequest);

        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        log.info("response {} {}", httpServletRequest.getServletPath(), httpServletResponse.getStatus());
    }
}
