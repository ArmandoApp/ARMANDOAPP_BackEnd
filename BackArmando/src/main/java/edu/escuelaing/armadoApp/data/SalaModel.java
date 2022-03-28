package edu.escuelaing.armadoApp.data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "salas")
public class SalaModel {
    @Id
    private String id;
    private List<String> usersId;

    public SalaModel(){
        usersId = new ArrayList<>();

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<String> usersId) {
        this.usersId = usersId;
    }



}
