package com.spring.gestionrevenue.Controller;


import com.spring.gestionrevenue.Entity.User;
import com.spring.gestionrevenue.Service.User.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "User management")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "Lister tous les users")
    @GetMapping("list")
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "Ajouter user")
    @PostMapping("add")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation(value = "Modifier user")
    @PutMapping("update/{id}")
    public User update(@RequestBody User user, @PathVariable("id") Long id) {
        return userService.update(user, id);
    }

    @ApiOperation(value = "Supprimmer user")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.delete(id);
    }


    @ApiOperation(value = "Find user by provided id")
    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
