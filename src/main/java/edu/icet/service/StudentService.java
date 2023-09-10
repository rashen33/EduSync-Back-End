package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void setNewStudent(Student newStudent);

    List<Student> getRegisteredStudent();

    Iterable<StudentEntity> retrieveStudentByUserName(String userName);

    public void setStudentToTheRegister(Long id, Student student);

    Iterable<StudentEntity> searchStudent(String name);

    public void deleteStudent(Long id);

    public Iterable<StudentEntity> getStudent();
}