package edu.icet.service;

import edu.icet.dao.ImageEntity;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.ImageRepository;
import edu.icet.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository repository;

    @Autowired
    ImageRepository imageRepository;
    @Override
    public void setStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setDob(student.getDob());
        studentEntity.setSex(student.getSex());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setTpNumber(student.getTpNumber());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setNic(student.getNic());
        studentEntity.setSchool(student.getSchool());
        studentEntity.setDepartment(student.getDepartment());
        studentEntity.setCourse(student.getCourse());
        repository.save(studentEntity);
    }
    @Override
    public Iterable<StudentEntity> getStudent() {
        return repository.findAll();
    }

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(bytes);

            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setImageData(base64Image);
            imageRepository.save(imageEntity);
            return "Image Uploaded";

        }
        return "Image upload fail";
    }


}
