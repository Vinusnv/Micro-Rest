package com.microservice.microserviceproject.PAYLOADS;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Managerdto {
    private int id;
    private int age;
    private String name;
    private String city;
    private String dept;
    private String company;
    
    private Date date;
    
}
