package com.example.app.repository;

import com.example.app.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    private static final String ADMINPASS = "00000";
    private static final String MANAGERPASS = "12345";
    private boolean passwordValid(String password) {
        return !password.equals(ADMINPASS) && !password.equals(MANAGERPASS) && password.matches("[0-9]\\d{4}");
    }
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (user.equals("admin") && password.equals(ADMINPASS)) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("manager") && password.equals(MANAGERPASS)) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (user.equals("user") && passwordValid(password)) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }
}



