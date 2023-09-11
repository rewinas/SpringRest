package com.kuraz.Rest.rest;


import com.kuraz.Rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Biruk","Zelalem"));
        theStudents.add(new Student("Hermella","Belay"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }


    //return by index of an array
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId >= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student Id Not Found - "+studentId);
        }
        return theStudents.get(studentId);
    }


}
