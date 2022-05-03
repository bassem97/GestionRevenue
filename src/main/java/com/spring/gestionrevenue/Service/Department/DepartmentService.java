package com.spring.gestionrevenue.Service.Department;

import com.spring.gestionrevenue.Entity.Department;
import com.spring.gestionrevenue.Repository.DepartmentRepository;
import com.spring.gestionrevenue.Service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService, ICrudService<Department,Long> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department, Long aLong) {
        if (departmentRepository.findById(aLong).isPresent()) {
            Department department1 = departmentRepository.findById(aLong).get();
            department1.setNom(department.getNom());

            return departmentRepository.save(department1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        departmentRepository.deleteById(aLong);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Long aLong) {
        return departmentRepository.findById(aLong).get();
    }
}
