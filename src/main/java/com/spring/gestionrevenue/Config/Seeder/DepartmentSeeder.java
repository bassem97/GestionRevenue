package com.spring.gestionrevenue.Config.Seeder;

import com.spring.gestionrevenue.Controller.ServiceController;
import com.spring.gestionrevenue.Entity.Department;
import com.spring.gestionrevenue.Repository.DepartmentRepository;
import com.spring.gestionrevenue.Service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSeeder {

    Department department1 ;
    Department department2 ;

    @Autowired
    DepartmentService departmentService;

    public void seed() {
        department1 = new Department("Departement 1");
        department2 = new Department("Departement 2");
        if(departmentService.findAll().isEmpty()) {
            departmentService.add(department1);
            departmentService.add(department2);
        }

    }
}
