package com.spring.gestionrevenue.Repository;

import com.spring.gestionrevenue.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
