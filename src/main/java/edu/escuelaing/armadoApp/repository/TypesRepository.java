package edu.escuelaing.armadoApp.repository;

import edu.escuelaing.armadoApp.data.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypesRepository extends MongoRepository<Type, String> {
}
