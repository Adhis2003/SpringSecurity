package com.dhi.SpringSecurity.Service;

import com.dhi.SpringSecurity.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentService {

    List<Student> ls = new ArrayList<>(Arrays.asList(
            new Student(1, "adhi", "a"),
            new Student(2, "bhi", "c"),
            new Student(3, "vdx", "a")
    ));


    public List<Student> getLs(){
        return ls;
    }

    public void postLs(Student student){
        ls.add(student);
    }
}
