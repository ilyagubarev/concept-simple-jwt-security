package com.ilyagubarev.concepts.jwt.simple.server.security.impls;

import java.time.Instant;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.ilyagubarev.concepts.jwt.simple.server.domain.users.UserEntity;
import com.ilyagubarev.concepts.jwt.simple.server.domain.users.UserRepository;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserAuthentication;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserAuthenticationService;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserCredentials;
import com.ilyagubarev.concepts.jwt.simple.server.security.UserPasswordHashFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserAuthenticationService implements UserAuthenticationService {

    @Autowired
    private UserPasswordHashFactory hashes;

    @Autowired
    private UserRepository users;

    @Override
    public UserAuthentication authenticate(UserCredentials credentials) {
        UserEntity user = getUser(credentials.getLogin());
        if (isNotValid(credentials.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("hashes are different");
        }
        return createAuthentication(user);
    }

    private UserEntity getUser(String login) {
        return users
                .findByLogin(login)
                .stream()
                .findAny()
                .orElseThrow(() -> {return new RuntimeException("user not found");});
    }

    private boolean isNotValid(String password, String passwordHash) {
        String hash = hashes.create(password);
        return hash.equals(passwordHash);
    }

    private UserAuthentication createAuthentication(UserEntity user) {
        UserAuthentication result = new UserAuthentication();
        result.setId(user.getId());
        result.setPasswordHash(user.getPasswordHash());
        result.setCompanyType(user.getCompany().getType());
        result.setRoles(new HashSet(user.getRoles()));
        result.setAuthenticated(Instant.now());
        return result;
    }
}
