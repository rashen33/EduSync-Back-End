package edu.icet.repositoary;

import edu.icet.dao.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity,Long> {
}