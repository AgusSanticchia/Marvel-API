package com.test.api.web.interceptor;

import com.test.api.exception.ApiErrorException;
import com.test.api.persistance.entity.UserInteractionLog;
import com.test.api.persistance.repository.UserInteractionLogRepository;
import com.test.api.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class UserInteractionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInteractionLogRepository userLogRepository;

    @Autowired
    @Lazy
    private AuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Inteceptor: " + this.getClass().getName());

        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/comics") || requestURI.startsWith("/characters")) {
            UserInteractionLog userLog = new UserInteractionLog();
            userLog.setHttpMethod(request.getMethod());
            userLog.setUrl(request.getRequestURL().toString());

            UserDetails user = authenticationService.getUserLoggedIn();
            userLog.setUsername(user.getUsername());
            userLog.setRemoteAddress(request.getRemoteAddr());
            userLog.setTimestamp(LocalDateTime.now());

            try {
                userLogRepository.save(userLog);
                return true;
            } catch (Exception exception) {
                throw new ApiErrorException("The interaction log could not be saved correctly.");
            }
        }

        return true;
    }
}