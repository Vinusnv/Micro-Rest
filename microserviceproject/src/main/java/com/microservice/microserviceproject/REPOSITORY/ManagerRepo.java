package com.microservice.microserviceproject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.microserviceproject.ENTITY.Manager;

public interface ManagerRepo  extends JpaRepository<Manager ,Integer>
 {
    
}
