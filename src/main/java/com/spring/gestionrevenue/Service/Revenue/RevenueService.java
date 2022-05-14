package com.spring.gestionrevenue.Service.Revenue;

import com.spring.gestionrevenue.Entity.Result;
import com.spring.gestionrevenue.Entity.Revenue;
import com.spring.gestionrevenue.Repository.RevenueRepository;
import com.spring.gestionrevenue.Service.ICrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service @Slf4j
public class RevenueService implements IRevenueService, ICrudService<Revenue,Long> {

    @Autowired
    private RevenueRepository revenueRepository;


    @Override
    public Revenue add(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    @Override
    public Revenue update(Revenue revenue, Long aLong) {
        if (revenueRepository.findById(aLong).isPresent()) {
            Revenue revenue1 = revenueRepository.findById(aLong).get();
            revenue1.setDateDebut(revenue.getDateDebut());
            revenue1.setDateFin(revenue.getDateFin());
            revenue1.setMontant(revenue.getMontant());
            revenue1.setService(revenue.getService());

            return revenueRepository.save(revenue1);
        }
        return null;
    }

    @Override
    public void delete(Long aLong) {
        revenueRepository.deleteById(aLong);
    }

    @Override
    public List<Revenue> findAll() {
        return revenueRepository.findAll();
    }

    @Override
    public Revenue findById(Long aLong) {
        return null;
    }

    @Override
    public List<Result> getRevenueByMonth() {
        Map<String, Float> dates = new HashMap<>();
        Map<String, Float> result = new HashMap<>();
        List<Result> results = new ArrayList<>();

        this.findAll().stream().sorted(Comparator.comparing(Revenue::getDateFin))
                .collect(Collectors.toList())
                .forEach(revenue -> {
            dates.put(
                    new SimpleDateFormat("yyyy-MM-dd").format(revenue.getDateFin()),
                    revenue.getMontant()
            );
        });

        for (Map.Entry<String, Float> entry  : dates.entrySet()) {
            String key = entry.getKey().split("-")[0] + "/" + entry.getKey().split("-")[1];
            Float value = entry.getValue();
            Float oldValue = result.get(key) != null ? result.get(key) : 0;
            Result rss = new Result(key, oldValue + value);
            results.add(rss);
        }

        return results;
    }
}
