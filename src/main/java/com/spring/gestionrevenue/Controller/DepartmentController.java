package com.spring.gestionrevenue.Controller;

import com.spring.gestionrevenue.Entity.Department;
import com.spring.gestionrevenue.Service.Department.DepartmentService;
import com.spring.gestionrevenue.Service.Service.ServiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Department management")
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "Retreive all services")
    @GetMapping("list")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @ApiOperation(value = "Add department")
    @PostMapping("add")
    public Department add(@RequestBody Department department) {
        return departmentService.add(department);
    }

    @ApiOperation(value = "Update department")
    @PutMapping("update/{id}")
    public Department update(@RequestBody Department department,@PathVariable("id") Long id) {
        return departmentService.update(department, id);
    }

    @ApiOperation(value = "Delete department")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        departmentService.delete(id);
    }


    @ApiOperation(value = "Find department by provided id")
    @GetMapping("findById/{id}")
    public Department findById(@PathVariable("id") Long id) {
        return departmentService.findById(id);
    }
}
