package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    public void setStudent(Student student);
    public List<Student> getStudent();
    public Iterable<StudentEntity> searchStudent(String name);
}
