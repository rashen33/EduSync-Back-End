package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StudentService {
    public void setStudent(Student student);
    public Iterable<StudentEntity> getStudent();
}
