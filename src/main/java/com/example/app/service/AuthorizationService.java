package com.example.app.service;

import com.example.app.exception.InvalidCredentials;
import com.example.app.exception.UnauthorizedUser;
import com.example.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.example.app.model.Authorities;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

