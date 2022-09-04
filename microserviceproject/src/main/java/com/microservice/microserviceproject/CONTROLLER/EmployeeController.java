package com.microservice.microserviceproject.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.microserviceproject.ENTITY.Employee;
import com.microservice.microserviceproject.SERVICE.EmployeeService;

@RestController
@RequestMapping("/micro/emp/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Employee Creating here
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        Employee createdemp = this.service.createEmployee(emp);
        return new ResponseEntity<Employee>(createdemp, HttpStatus.CREATED);
    }

    // Updating the employee

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee emp) {
        Employee updatedemp = this.service.updateEmployee(id, emp);

        return new ResponseEntity<Employee>(updatedemp, HttpStatus.OK);
    }
    //Fetching all employee
@GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee>  allemp=this.service.getallemployee();

        return new ResponseEntity<List<Employee>>(allemp, HttpStatus.FOUND);
    }

    // Fetching the employee by id
    @GetMapping("/getbyid")
    public ResponseEntity<Employee> getEmployeebyid(@RequestParam(name = "id") int id) {
        Employee emp = this.service.getEmployeebyid(id);

        return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
    }

    // Fetching the employee by name
    @GetMapping("/getbyname")
    public ResponseEntity<Employee> getEmployeebyname(@RequestParam(name = "name") String name) {

        Employee emp = this.service.getEmployeebyname(name);

        return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);

    }

    // Fetching all the employees having the same age
    @GetMapping("/getbyage")
    public ResponseEntity<List<Employee>> getallemployeebyage(@RequestParam(name = "age") int age)

    {
        List<Employee> allemp = this.service.getallemployeebyage(age);

        return new ResponseEntity<List<Employee>>(allemp, HttpStatus.FOUND);
    }

    // Fetching all the employees having the same city
    @GetMapping("/getbycity")
    public ResponseEntity<List<Employee>> getallemployeebycity(@RequestParam(name = "city") String city)

    {
        List<Employee> allemp = this.service.getallemployeebycity(city);

        return new ResponseEntity<List<Employee>>(allemp, HttpStatus.FOUND);
    }

    // Fetching all the employees having the same dept
    @GetMapping("/getbydept")
    public ResponseEntity<List<Employee>> getallemployeebybranch(@RequestParam(name = "dept") String dept)

    {
        List<Employee> allemp = this.service.getallemployeebybranch(dept);

        return new ResponseEntity<List<Employee>>(allemp, HttpStatus.FOUND);
    }

    // deleting the employee by using the id
    @DeleteMapping("/delete")
    public ResponseEntity<Employee> deleteemployee(@RequestParam(name = "id") int id) {
        Employee emp = this.service.deleteemployee(id);

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

}
