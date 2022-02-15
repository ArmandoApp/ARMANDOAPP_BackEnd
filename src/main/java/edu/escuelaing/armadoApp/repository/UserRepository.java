package edu.escuelaing.armadoApp.repository;


import edu.escuelaing.armadoApp.data.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsername(String userName);

    List<UserModel> findUserModelByCategory(String category);
}