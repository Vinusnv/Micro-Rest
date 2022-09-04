package com.microservice.microserviceproject.SERVICE;

import java.util.List;

import com.microservice.microserviceproject.ENTITY.Manager;

public interface ManagerService {
    // creating all manager
    public Manager createmanager(Manager man);

    // updating the manager
    public Manager updatemanager(Manager man, int id);

    // deleting the manager
    public Manager deletemanager(int id);

    // fetching all the manager
    public List<Manager> getallmanager();
    // fetching the manager by id

    public Manager getmanagerbyid(int id);

    // fetching the manager by name
    public Manager getmanagerbyname(String name);

    // fetching all managers by age
    public List<Manager> getallmanagerbyage(int age);
    // fetching all managers by city

    public List<Manager> getallmanagerbycity(String city);

    // fetching all managers by dept
    public List<Manager> getallmanagerbydept(String dept);

    // fetching all managers by company
    public List<Manager> getallmaManagersbycompany(String company);

}
