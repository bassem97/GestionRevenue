package com.spring.gestionrevenue.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;

    @Column(unique=true)
    private String nom;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartment")
    @JsonIgnoreProperties({"services"})
    private Department department;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idService")
    @JsonIgnoreProperties({"service"})
    private List<Revenue> revenues;


    public Service() {
        revenues = new ArrayList<>();
    }

    public Service(String nom, String description, Department department) {
        this.nom = nom;
        this.description = description;
        this.department = department;
        revenues = new ArrayList<>();

    }
}
