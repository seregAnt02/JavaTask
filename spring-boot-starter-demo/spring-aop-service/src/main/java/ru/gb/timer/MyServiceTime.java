package ru.gb.timer;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.gb.aspect.Timer;

import java.io.IOException;

@Slf4j
@Timer
@Component
public class MyServiceTime {

    @Timer
    public void method1(String args1, int args2){
        log.info("method1: {} - {}", args1, args2);
    }
    public String method2(){
        log.info("method2");
        return "value";
    }
    public void method3(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("request {}", httpServletRequest);

        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        log.info("response {} {}", httpServletRequest.getServletPath(), httpServletResponse.getStatus());
    }
}
