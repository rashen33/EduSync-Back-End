package edu.icet.repository;

import edu.icet.dao.ImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
    Optional<ImageEntity> findByName(String fileName);
}
