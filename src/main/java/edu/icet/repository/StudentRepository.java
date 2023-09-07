package edu.icet.repository;

import edu.icet.dao.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
    Iterable<StudentEntity> findByName(String name);
    Optional<StudentEntity> findById(Long id);
    Iterable<StudentEntity> findByUserName(String userName);
    void deleteById(Long id);
}
