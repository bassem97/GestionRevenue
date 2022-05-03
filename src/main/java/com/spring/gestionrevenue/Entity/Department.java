package com.spring.gestionrevenue.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartment;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDepartment")
    @ApiModelProperty(hidden = true)
//    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<com.spring.gestionrevenue.Entity.Service> services;



    public Department() {
        this.services = new ArrayList<>();
    }

    public Department(String nom) {
        this.nom = nom;
        this.services = new ArrayList<>();
    }

}
