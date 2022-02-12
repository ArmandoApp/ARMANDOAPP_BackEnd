package edu.escuelaing.armadoApp.dto;

import java.util.Date;

public class UserDto {

    private String name;
    private String mail;
    private String password;
    private Date created;

    public UserDto(String name, String mail, String password, Date created) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
