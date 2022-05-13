package com.spring.gestionrevenue.Service.Service;

import com.spring.gestionrevenue.Entity.Service;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface IServiceService {
    HashMap<String, Float> getRevenueByService();

}
