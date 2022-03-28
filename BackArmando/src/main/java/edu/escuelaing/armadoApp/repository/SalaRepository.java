package edu.escuelaing.armadoApp.repository;
import edu.escuelaing.armadoApp.data.SalaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends MongoRepository<SalaModel,String>{

}
