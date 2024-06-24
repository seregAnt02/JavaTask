package ru.gb.http.aop;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.gb.timer.MyServiceTime;

import java.io.IOException;

@Slf4j
@Component
public class AopFilter implements Filter {

    @Autowired
    private MyServiceTime myServiceTime;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        myServiceTime.method1("ok", 1);
        myServiceTime.method2();
        myServiceTime.method3(request, response, chain);
    }
}
