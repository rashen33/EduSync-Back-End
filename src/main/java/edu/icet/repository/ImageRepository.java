package edu.icet.repository;

import edu.icet.dao.ImageEntity;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
}
