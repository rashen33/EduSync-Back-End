package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public void setNewStudent(@RequestBody Student newStudent){
        studentService.setNewStudent(newStudent);
    }

    @GetMapping
    public List<Student> getRegisteredStudent(){
        return studentService.getRegisteredStudent();
    }

    @GetMapping("/{userName}")
    public Iterable<StudentEntity> retrieveStudentByName(@PathVariable String userName){
        return studentService.retrieveStudentByUserName(userName);
    }

    @PutMapping("/{id}")
    public void setStudentToTheRegister(@PathVariable Long id, @RequestBody Student student){
        studentService.setStudentToTheRegister(id,student);
    }

    @GetMapping("/search/{name}")
    public Iterable<StudentEntity> searchStudent(@PathVariable String name){
        return studentService.searchStudent(name);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("User deleted successfully!.");
    }

    @GetMapping("/all")
    public Iterable<StudentEntity> getStudent(){
        return studentService.getStudent();
    }

    @GetMapping("current-student/{id}")
    public Optional<StudentEntity> retrieveStudentById(@PathVariable Long id){
        return studentService.retrieveStudentById(id);
    }

}
