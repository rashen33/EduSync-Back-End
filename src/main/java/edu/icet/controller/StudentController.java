package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.dao.StudentEntity;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/student")
    public void setStudent(@RequestBody Student student){
        studentService.setStudent(student);
    }
    @GetMapping("/student")
    public Iterable<StudentEntity> getStudent(){
        return studentService.getStudent();
    }

}
