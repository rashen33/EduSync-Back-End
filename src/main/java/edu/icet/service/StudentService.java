package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

public interface StudentService {
    public void setStudent(Student student);
    public Iterable<StudentEntity> getStudent();
    public Iterable<StudentEntity> searchStudent(String name);
}
