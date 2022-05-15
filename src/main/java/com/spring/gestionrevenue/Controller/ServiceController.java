package com.spring.gestionrevenue.Controller;

import com.spring.gestionrevenue.Entity.Result;
import com.spring.gestionrevenue.Entity.Service;
import com.spring.gestionrevenue.Repository.ServiceRepository;
import com.spring.gestionrevenue.Service.Service.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Service management")
@RequestMapping("/service/")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @ApiOperation(value = "Retreive all services")
    @GetMapping("list")
    public List<Service> findAll() {
        return serviceService.findAll();
    }

    @ApiOperation(value = "Add service")
    @PostMapping("add")
    public Service add(@RequestBody Service service) {
        return serviceService.add(service);
    }

    @ApiOperation(value = "Update service")
    @PutMapping("update/{id}")
    public Service update(@RequestBody Service service,@PathVariable("id") Long id) {
        return serviceService.update(service, id);
    }

    @ApiOperation(value = "Delete service")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        serviceService.delete(id);
    }



    @ApiOperation(value = "Find service by provided id")
    @GetMapping("findById/{id}")
    public Service findById(@PathVariable("id") Long id) {
        return serviceService.findById(id);
    }

    @ApiOperation(value = "retreive totale revenues by service")
    @GetMapping("getTotalRevenuesByService")
    public List<Result>  getRevenueByService() {
        return serviceService.getRevenueByService();
    }
}
