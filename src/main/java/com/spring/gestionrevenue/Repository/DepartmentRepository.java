package com.spring.gestionrevenue.Repository;

import com.spring.gestionrevenue.Entity.Department;
import com.spring.gestionrevenue.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
