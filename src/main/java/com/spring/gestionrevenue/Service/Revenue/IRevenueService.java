package com.spring.gestionrevenue.Service.Revenue;

import com.spring.gestionrevenue.Entity.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRevenueService {
    List<Result> getRevenueByMonth();
}
