package com.spring.gestionrevenue.Controller;

import com.spring.gestionrevenue.Entity.Revenue;
import com.spring.gestionrevenue.Service.Revenue.RevenueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Revenue management")
@RequestMapping("/revenue/")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;


    @ApiOperation(value = "Retreive all revenues")
    @GetMapping("list")
    public List<Revenue> findAll() {
        return revenueService.findAll();
    }

    @ApiOperation(value = "Add revenue")
    @PostMapping("add")
    public Revenue add(@RequestBody Revenue revenue) {
        return revenueService.add(revenue);
    }

    @ApiOperation(value = "Update revenue")
    @PutMapping("update/{id}")
    public Revenue update(@RequestBody Revenue revenue,@PathVariable("id") Long id) {
        return revenueService.update(revenue, id);
    }

    @ApiOperation(value = "Delete revenue")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        revenueService.delete(id);
    }


    @ApiOperation(value = "Find revenue by provided id")
    @GetMapping("findById/{id}")
    public Revenue findById(@PathVariable("id") Long id) {
        return revenueService.findById(id);
    }
}
