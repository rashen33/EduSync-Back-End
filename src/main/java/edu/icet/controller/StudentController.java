package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<Student> retrieveStudentByName(@PathVariable String userName){
        return studentService.retrieveStudentByUserName(userName);
    }
//    @PostMapping
//    public void setStudent(@RequestBody Student student){
//        studentService.setStudent(student);
//    }
//    @GetMapping
//    public List<Student> getStudent(){
//        return studentService.getStudent();
//    }
//    @GetMapping("/{name}")
//    public List<Student> searchStudent(@PathVariable String name){
//        return studentService.searchStudent(name);
//    }
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
//        studentService.deleteStudent(id);
//        return ResponseEntity.ok("User deleted successfully!.");
//    }

}
