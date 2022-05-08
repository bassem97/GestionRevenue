package com.spring.gestionrevenue.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString @NoArgsConstructor @AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(unique=true)
    private String username;

    @Column(unique=true)
    private String email;
    private String password;

    private String role;



    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public User(String username, String email, String password,String role) {
        new User( username, email,  password);
        this.role = role;

    }
}
