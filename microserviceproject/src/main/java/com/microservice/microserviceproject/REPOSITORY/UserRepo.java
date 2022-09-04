package com.microservice.microserviceproject.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.microserviceproject.ENTITY.User;

public interface UserRepo extends JpaRepository<User ,Integer>
{
    
}
