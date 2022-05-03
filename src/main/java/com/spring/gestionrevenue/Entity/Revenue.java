package com.spring.gestionrevenue.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Revenue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevenue;

    private float montant;
    private Date  dateDebut;
    private Date  dateFin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idService")
//    @JsonIgnoreProperties({"services"})
    private com.spring.gestionrevenue.Entity.Service  service;



}
