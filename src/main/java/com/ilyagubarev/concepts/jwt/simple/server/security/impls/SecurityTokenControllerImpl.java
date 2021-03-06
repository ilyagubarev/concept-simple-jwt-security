package com.ilyagubarev.concepts.jwt.simple.server.security.impls;

import com.ilyagubarev.concepts.jwt.simple.server.security.SecurityTokenService;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserAuthenticationService;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication/tokens")
public class SecurityTokenControllerImpl {

    @Autowired
    private SecurityTokenService tokens;

    @Autowired
    private UserAuthenticationService users;

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody(required = true) UserCredentials credentials) {
        throw new UnsupportedOperationException();
    }
}
