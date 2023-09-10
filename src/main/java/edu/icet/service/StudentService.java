package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void setNewStudent(Student newStudent);

    List<Student> getRegisteredStudent();

    Iterable<StudentEntity> retrieveStudentByUserName(String userName);

    void setStudentToTheRegister(Long id, Student student);

    Iterable<StudentEntity> searchStudent(String name);

    void deleteStudent(Long id);

    Iterable<StudentEntity> getStudent();
    Optional<StudentEntity> retrieveStudentById(Long id);
}