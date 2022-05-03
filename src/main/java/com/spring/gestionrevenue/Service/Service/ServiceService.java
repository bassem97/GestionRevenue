package com.spring.gestionrevenue.Service.Service;

import com.spring.gestionrevenue.Entity.Department;
import com.spring.gestionrevenue.Repository.ServiceRepository;
import com.spring.gestionrevenue.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService, ICrudService<com.spring.gestionrevenue.Entity.Service,Long> {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public com.spring.gestionrevenue.Entity.Service add(com.spring.gestionrevenue.Entity.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public com.spring.gestionrevenue.Entity.Service update(com.spring.gestionrevenue.Entity.Service service, Long aLong) {
        if (serviceRepository.findById(aLong).isPresent()) {
            com.spring.gestionrevenue.Entity.Service service1 = serviceRepository.findById(aLong).get();
            service1.setDescription(service.getDescription());
            service1.setNom(service.getNom());
            service1.setDepartment(service.getDepartment());
            return serviceRepository.save(service1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        serviceRepository.deleteById(aLong);
    }

    @Override
    public List<com.spring.gestionrevenue.Entity.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public com.spring.gestionrevenue.Entity.Service findById(Long aLong) {
        return serviceRepository.findById(aLong).get();
    }
}
