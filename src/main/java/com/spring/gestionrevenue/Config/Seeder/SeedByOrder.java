package com.spring.gestionrevenue.Config.Seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedByOrder {

    @Autowired
    DepartmentSeeder departmentSeeder;

    @Autowired
    UserSeeder userSeeder;

    @Autowired
    ServiceSeeder serviceSeeder;

    @Autowired
    private RevenueSeeder revenueSeeder;

    public void init() {
        departmentSeeder.seed();
        userSeeder.seed();
        serviceSeeder.seed();
        revenueSeeder.seed();
    }
}
