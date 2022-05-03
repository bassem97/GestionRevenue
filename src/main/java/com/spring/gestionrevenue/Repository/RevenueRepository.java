package com.spring.gestionrevenue.Repository;

import com.spring.gestionrevenue.Entity.Revenue;
import com.spring.gestionrevenue.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {
}
