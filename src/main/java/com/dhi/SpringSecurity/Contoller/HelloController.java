package com.dhi.SpringSecurity.Contoller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class HelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest servelt){
        return "Hello my friend "+servelt.getSession().getId();
    }
}
