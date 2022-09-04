package com.microservice.microserviceproject.SERVICEIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microserviceproject.ENTITY.Employee;
import com.microservice.microserviceproject.REPOSITORY.EmployeeRepo;
import com.microservice.microserviceproject.SERVICE.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    // Creating the employee

    @Override
    public Employee createEmployee(Employee emp) {

        Employee createdemployee = this.repo.save(emp);
        return createdemployee;
    }

    // Updating the employee using the id
    @Override
    public Employee updateEmployee(int id, Employee emp) {

        Employee femp = this.repo.findById(id).get();

        femp.setAge(emp.getAge());
        femp.setCity(emp.getCity());
        femp.setDept(emp.getDept());
        femp.setName(emp.getName());
        // femp.setId(emp.getId());

        Employee updatedemployee = this.repo.save(femp);

        return updatedemployee;
    }

    // Fetching the employee by id
    @Override
    public Employee getEmployeebyid(int id) {
        Employee emp = this.repo.findById(id).get();
        return emp;
    }

    // Fetching the employee by name
    @Override
    public Employee getEmployeebyname(String name) {
        List<Employee> allemp = this.repo.findAll();

        for (Employee emp : allemp) {
            if (emp.getName().equalsIgnoreCase(name)) {
                return emp;
            }
        }
        return null;
    }

    // Fetching all the employees having the same age
    @Override
    public List<Employee> getallemployeebyage(int age) {
        List<Employee> allemp = this.repo.findAll();

        List<Employee> updatedlist = allemp.stream().filter(emp -> emp.getAge() == age).collect(Collectors.toList());

        return updatedlist;
    }

    // Fetching all the employees having the same city
    @Override
    public List<Employee> getallemployeebycity(String city) {
        List<Employee> allemp = this.repo.findAll();

        List<Employee> updated = allemp.stream().filter(name -> name.getCity().equalsIgnoreCase(city)).toList();
        return updated;
    }

    // Fetching all the employees having the same dept
    @Override
    public List<Employee> getallemployeebybranch(String dept) {
        List<Employee> allemp = this.repo.findAll();

        List<Employee> updatedlist = allemp.stream().filter(emp -> emp.getDept().equalsIgnoreCase(dept))
                .collect(Collectors.toList());

        return updatedlist;
    }

    // deleting the employee by using the id
    public Employee deleteemployee(int id)

    {
        Employee emp = this.repo.findById(id).get();

        this.repo.delete(emp);

        return emp;
    }

    @Override
    public List<Employee> getallemployee() {

        List<Employee> allemp = this.repo.findAll();
        return allemp;
    }

}
