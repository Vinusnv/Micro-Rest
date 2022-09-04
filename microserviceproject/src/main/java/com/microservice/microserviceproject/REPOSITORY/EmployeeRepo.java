package com.microservice.microserviceproject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.microserviceproject.ENTITY.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
    
}
