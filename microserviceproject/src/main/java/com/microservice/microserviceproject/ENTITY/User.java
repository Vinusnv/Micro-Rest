package com.microservice.microserviceproject.ENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor



@Entity
@Table(name="User")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "Id")
private int id;
@Column(name = "Age")
private int age;
@Column(name = "Name")
private String name;
@Column(name = "City")
private String city;
public User(int id, int age, String name, String city) {
    this.id = id;
    this.age = age;
    this.name = name;
    this.city = city;
}

    
}
