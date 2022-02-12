package edu.escuelaing.armadoApp.repository;


import edu.escuelaing.armadoApp.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
