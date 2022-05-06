package com.spring.gestionrevenue.Config.Seeder;


import com.spring.gestionrevenue.Service.Service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceSeeder {

    @Autowired
    ServiceService serviceService;
    @Autowired
    DepartmentSeeder departmentSeeder;

    com.spring.gestionrevenue.Entity.Service service1;
    com.spring.gestionrevenue.Entity.Service service2;
    com.spring.gestionrevenue.Entity.Service service3;

    public void seed() {
        if(serviceService.findAll().isEmpty()){

            service1 = new com.spring.gestionrevenue.Entity.Service("service transport", "description service transport",departmentSeeder.department1);
            service2 = new com.spring.gestionrevenue.Entity.Service("service aprés vente", "description service aprés vente",departmentSeeder.department2);
            service3 = new com.spring.gestionrevenue.Entity.Service("service logistique", "description service logistique",departmentSeeder.department2);

            serviceService.add(service1);
            serviceService.add(service2);
            serviceService.add(service3);
        }
    }
}
