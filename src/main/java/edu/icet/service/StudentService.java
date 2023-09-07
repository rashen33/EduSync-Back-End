package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void setNewStudent(Student newStudent);
    List<Student> getRegisteredStudent();
    Iterable<StudentEntity> retrieveStudentByUserName(String userName);

    public void setStudentTotheRegister(Long id, Student student);

//    public List<Student> getStudent();
//    public List<Student> searchStudent(String name);
//
//    void deleteStudent(Long id);
}
