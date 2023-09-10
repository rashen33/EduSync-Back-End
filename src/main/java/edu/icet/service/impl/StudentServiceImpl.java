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
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentRepository repository;

    @Override
    public void setNewStudent(Student newStudent) {
        StudentEntity studentEntityNS = new StudentEntity();
        studentEntityNS.setUserName(newStudent.getUserName());
        studentEntityNS.setStudentEmail(newStudent.getStudentEmail());
        studentEntityNS.setPassword(newStudent.getPassword());

        repository.save(studentEntityNS);
    }
    @Override
    public List<Student> getRegisteredStudent() {
        Iterable<StudentEntity> regStudentList = repository.findAll();

        Iterator<StudentEntity> iterator = regStudentList.iterator();

        List<Student> regStudentModelList = new ArrayList<>();

        while(iterator.hasNext()){
            StudentEntity regStudentDao = iterator.next();
            Student regStudentDto = Student.builder()
                    .userName(regStudentDao.getUserName())
                    .studentEmail(regStudentDao.getStudentEmail())
                    .password(regStudentDao.getPassword())
                    .build();

            regStudentModelList.add(regStudentDto);
        }
        return regStudentModelList;
    }
    @Override
    public Iterable<StudentEntity> retrieveStudentByUserName(String userName) {
        return repository.findByUserName(userName);
    }
    @Override
    public void setStudentToTheRegister(Long id, Student student){

        StudentEntity studentEntity = repository.findById(id).get();
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
    public Iterable<StudentEntity> searchStudent(String name) {
        return repository.findByName(name);
    }
    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
    @Override
    public Iterable<StudentEntity> getStudent() {
        return repository.findAll();
    }


}