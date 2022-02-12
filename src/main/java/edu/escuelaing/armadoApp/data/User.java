package edu.escuelaing.armadoApp.data;

import edu.escuelaing.armadoApp.dto.UserDto;

import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class User {

    private String id;
    private String name;
    private String mail;
    private String password;
    private Date created;
    private AtomicInteger atomicInteger = new AtomicInteger();


    public User(UserDto userDto) {
        this.id = String.valueOf(atomicInteger.incrementAndGet());
        this.name = userDto.getName();
        this.mail = mail;
        this.password = password;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
