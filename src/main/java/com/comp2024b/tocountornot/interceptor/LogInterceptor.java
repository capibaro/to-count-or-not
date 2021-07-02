package com.comp2024b.tocountornot.interceptor;

import com.comp2024b.tocountornot.ToCountOrNotApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ToCountOrNotApplication.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        String invokeInfo = request.getRemoteAddr() + " " +
                request.getAttribute("user") + " " +
                request.getMethod() + " " +
                request.getRequestURI() + " " +
                "handled in " + (endTime - startTime) + "ms";
        logger.info(invokeInfo);
    }
}
