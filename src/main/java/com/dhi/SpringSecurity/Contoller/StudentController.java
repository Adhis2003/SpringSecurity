package com.dhi.SpringSecurity.Contoller;

import com.dhi.SpringSecurity.Model.Student;
import com.dhi.SpringSecurity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getLs();
    }

    @PostMapping("/students")
    public void postStudent(@RequestBody Student student){
        service.postLs(student);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(CsrfToken csrfToken) {
        return csrfToken;
    }


}
