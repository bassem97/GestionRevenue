package com.spring.gestionrevenue.Utils;

import com.spring.gestionrevenue.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtRespone {
    private String token;

    private User user;

    public JwtRespone(String token,User user) {
        this.token = token;
        this.user = user;
    }

    public JwtRespone() {
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
