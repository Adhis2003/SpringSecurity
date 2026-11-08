package com.dhi.SpringSecurity.Contoller;


import com.dhi.SpringSecurity.Model.Users;
import com.dhi.SpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public Users registerUser(@RequestBody Users users){
        return service.registerUser(users);
    }

    @PostMapping("/login")
    public String Login(@RequestBody Users users){
        return service.verify(users);
    }
}
