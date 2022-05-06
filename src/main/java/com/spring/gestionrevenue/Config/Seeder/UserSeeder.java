package com.spring.gestionrevenue.Config.Seeder;

import com.spring.gestionrevenue.Entity.User;
import com.spring.gestionrevenue.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder {

    public User user1 = new User("bassem97","bassem.jadoui@gmail.com","123456");
    public User user2 = new User("hamdi2022","hamdi@gmail.com","123456");
    public User user3 = new User("malek2022","malek@gmail.com","123456");

    @Autowired
    private UserService userService;

    public void seed() {
        if(userService.findAll().isEmpty()) {
            userService.add(user1);
            userService.add(user2);
            userService.add(user3);
        }

    }
}
