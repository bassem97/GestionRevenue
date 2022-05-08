package com.spring.gestionrevenue.Service.User;

import com.spring.gestionrevenue.Entity.User;

public interface IUserService {
    User findByEmail(String email);
}
