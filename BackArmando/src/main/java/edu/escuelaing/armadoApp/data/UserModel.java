package edu.escuelaing.armadoApp.data;

import edu.escuelaing.armadoApp.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {


    @Id
    private String id;

    private String username;

    private String password;

    private String role;

    private String category;


    public UserModel() {

    }

    public UserModel(UserDto userDto) {

        this.username = userDto.getUserName();
        this.password = userDto.getPassword();
        this.role = userDto.getRole();
        this.category = userDto.getCategory();

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}