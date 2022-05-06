package com.spring.gestionrevenue.Config.Seeder;

import com.spring.gestionrevenue.Entity.Revenue;
import com.spring.gestionrevenue.Service.Revenue.RevenueService;
import com.spring.gestionrevenue.Service.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class RevenueSeeder {

    @Autowired
    ServiceSeeder serviceSeeder;

    Revenue revenue1;
    Revenue revenue2;
    Revenue revenue3;

    @Autowired
    private RevenueService revenueService;

    public void seed() {
        revenue1 = new Revenue(33F,new Date(2022, Calendar.APRIL,15) , new Date(2022, Calendar.MAY,1),serviceSeeder.service1 );
        revenue2 = new Revenue(42F,new Date(2022, Calendar.MAY,2) , new Date(2022, Calendar.MAY,10),serviceSeeder.service1 );
        revenue3 = new Revenue(42F,new Date(2022, Calendar.MAY,11) , new Date(2022, Calendar.MAY,20),serviceSeeder.service2 );

        revenueService.add(revenue1);
        revenueService.add(revenue2);
        revenueService.add(revenue3);
    }
}
