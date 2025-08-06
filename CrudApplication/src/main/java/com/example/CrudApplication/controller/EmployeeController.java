package com.example.CrudApplication.controller;

import com.example.CrudApplication.entity.Employee;
import com.example.CrudApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee emp) {
        return ResponseEntity.ok(service.save(emp));
    }

    @GetMapping("/employee")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Employee emp = service.getById(id);
        return emp != null ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
