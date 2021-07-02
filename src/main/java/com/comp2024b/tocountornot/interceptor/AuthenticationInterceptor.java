package com.comp2024b.tocountornot.interceptor;

import com.comp2024b.tocountornot.annotation.NoTokenRequired;
import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.User;
import com.comp2024b.tocountornot.exception.BadRequestException;
import com.comp2024b.tocountornot.service.UserService;
import com.comp2024b.tocountornot.util.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public AuthenticationInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
        if (!(object instanceof HandlerMethod)) {
            return false;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(NoTokenRequired.class)) {
            NoTokenRequired noTokenRequired = method.getAnnotation(NoTokenRequired.class);
            if (noTokenRequired.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired tokenRequired = method.getAnnotation(TokenRequired.class);
            if (tokenRequired.required()) {
                String token = request.getHeader("Cookie");
                if (token == null) {
                    throw new BadRequestException("no token found");
                }
                String name = Token.decode(token);
                request.setAttribute("user", name);
                if (!userService.ExistUser(name)) {
                    throw new BadRequestException("invalid token");
                }
                User user = userService.getUserByName(name);
                request.setAttribute("uid", user.getId());
                Token.verify(token);
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e) {}
}
