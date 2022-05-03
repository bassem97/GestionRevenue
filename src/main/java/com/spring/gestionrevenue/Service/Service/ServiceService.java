package com.spring.gestionrevenue.Service.Service;

import com.spring.gestionrevenue.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService{

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public com.spring.gestionrevenue.Entity.Service add(com.spring.gestionrevenue.Entity.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public com.spring.gestionrevenue.Entity.Service update(com.spring.gestionrevenue.Entity.Service service, Long id) {
        return serviceRepository.save(service);
    }

    @Override
    public void delete(long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<com.spring.gestionrevenue.Entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public com.spring.gestionrevenue.Entity.Service findById(Long id) {
        return serviceRepository.findById(id).get();
    }
}
