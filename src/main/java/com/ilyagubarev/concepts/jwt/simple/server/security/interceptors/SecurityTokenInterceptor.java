package com.ilyagubarev.concepts.jwt.simple.server.security.interceptors;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityContext;
import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityToken;
import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityTokenService;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserAuthentication;
import org.springframework.beans.factory.annotation.Value;

public class SecurityTokenInterceptor extends HandlerInterceptorAdapter {

    private static final String SECURITY_TOKEN_HEADER = "X-Auth-Header";

    @Value("${security.token.header}")
    private String securityTokenHeader;

    @Autowired
    private SecurityContext context;

    @Autowired
    private SecurityTokenService tokens;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Optional<SecurityToken> token = receiveToken(request);
        if (token.isPresent()) {
            try {
                UserAuthentication authentication = tokens.detokenize(token.get());
                context.setAuthentication(authentication);
            } catch (Exception exception) {
                // TODO: log down broken/expired tokens
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelView) throws Exception {
        Optional<UserAuthentication> authentication = context.getAuthentication();
        if (authentication.isPresent()) {
            SecurityToken token = tokens.tokenize(authentication.get());
            sendToken(token, response);
        }
    }

    private Optional<SecurityToken> receiveToken(HttpServletRequest request) {
        String token = request.getHeader(SECURITY_TOKEN_HEADER);
        return token != null ? Optional.of(new SecurityToken(token)) : Optional.empty();
    }

    private void sendToken(SecurityToken token, HttpServletResponse response) {
        response.addHeader(SECURITY_TOKEN_HEADER, token.toString());
    }
}
