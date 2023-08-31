package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.dao.StudentEntity;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/image")
    public String saveImage(@RequestParam("image")MultipartFile file) throws IOException {
        return studentService.saveImage(file);
    }
    @GetMapping("/{fileName}")
    public byte[] getImage(@PathVariable String fileName){
        return studentService.getImage(fileName);
    }


}
