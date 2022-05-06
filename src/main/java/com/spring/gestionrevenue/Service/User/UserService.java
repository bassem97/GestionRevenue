package com.spring.gestionrevenue.Service.User;


import com.spring.gestionrevenue.Entity.User;
import com.spring.gestionrevenue.Repository.UserRepository;
import com.spring.gestionrevenue.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService, ICrudService<User,Long> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public User add(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long aLong) {
        if (userRepository.findById(aLong).isPresent()) {
            User user1 = userRepository.findById(aLong).get();
            user1.setUsername(user.getUsername());
            user1.setEmail(user.getEmail());
            user1.setPassword(bcryptEncoder.encode(user.getPassword()));

            return userRepository.save(user1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long aLong) {
        return userRepository.findById(aLong).get();
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
