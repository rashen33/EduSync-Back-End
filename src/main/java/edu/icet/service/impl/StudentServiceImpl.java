package edu.icet.service.impl;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;

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
    public List<Student> getStudent() {
        Iterable<StudentEntity> studentList = repository.findAll();

        Iterator<StudentEntity> iterator = studentList.iterator();

        List<Student> studentModelList = new ArrayList<>();

        while(iterator.hasNext()){
            StudentEntity studentDao = iterator.next();
            Student studentDto = Student.builder()
                    .name(studentDao.getName())
                    .dob(studentDao.getDob())
                    .sex(studentDao.getSex())
                    .email(studentDao.getEmail())
                    .tpNumber(studentDao.getTpNumber())
                    .address(studentDao.getAddress())
                    .nic(studentDao.getNic())
                    .school(studentDao.getSchool())
                    .department(studentDao.getDepartment())
                    .course(studentDao.getCourse())
                    .build();

            studentModelList.add(studentDto);
        }

        return studentModelList;
    }

    @Override
    public Iterable<StudentEntity> searchStudent(String name) {
        return repository.findByName(name);
    }

}