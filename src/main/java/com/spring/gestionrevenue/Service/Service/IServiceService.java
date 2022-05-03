package com.spring.gestionrevenue.Service.Service;

import com.spring.gestionrevenue.Entity.Service;

import java.util.List;

public interface IServiceService {
    Service add(Service detailFacture);
    Service update(Service detailFacture, Long id);
    void delete(long id);
    List<Service> findAll();
    Service findById(Long id);
}
