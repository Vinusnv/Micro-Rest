package com.microservice.microserviceproject.SERVICE;

import java.util.List;

import com.microservice.microserviceproject.ENTITY.Employee;


public interface EmployeeService 
 {

    public Employee createEmployee(Employee emp);
 

    public Employee updateEmployee(int id,Employee emp);

    public List<Employee>  getallemployee();


    public Employee getEmployeebyid(int id);

    public Employee getEmployeebyname(String name);

    public List<Employee> getallemployeebyage(int age);


    public List<Employee>  getallemployeebycity(String city);


    public List<Employee>  getallemployeebybranch(String dept);
    

    public Employee deleteemployee(int id);
}
