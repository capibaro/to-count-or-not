package com.comp2024b.tocountornot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInterceptor implements HandlerInterceptor {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        Date date = new Date();
        request.setAttribute("date", date);
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        Date date = (Date) request.getAttribute("date");
        System.out.print(sdf.format(date) + "  ");
        System.out.print(request.getRemoteAddr() + " ");
        System.out.print(request.getAttribute("user") + " ");
        System.out.print(request.getMethod() + " ");
        System.out.print(request.getRequestURI() + " ");
        System.out.println("handled in " + (endTime - startTime) + "ms");
    }
}
