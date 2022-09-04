package com.microservice.microserviceproject.SERVICEIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microserviceproject.ENTITY.Manager;
import com.microservice.microserviceproject.REPOSITORY.ManagerRepo;
import com.microservice.microserviceproject.SERVICE.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepo repo;

    // creating all manager
    @Override
    public Manager createmanager(Manager man) {
        Manager savedmanager = this.repo.save(man);
        return savedmanager;
    }

    // updating the manager
    @Override
    public Manager updatemanager(Manager man, int id) {
        Manager updatedmanger = this.repo.findById(id).get();
        updatedmanger.setAge(man.getAge());
        updatedmanger.setName(man.getName());
        updatedmanger.setCity(man.getCity());
        updatedmanger.setCompany(man.getCompany());
        updatedmanger.setDept(man.getDept());
        updatedmanger.setDate(man.getDate());
        this.repo.save(updatedmanger);

        return updatedmanger;
    }

    // deleting the manager
    @Override
    public Manager deletemanager(int id) {
        Manager man = this.repo.findById(id).get();

        this.repo.delete(man);
        return man;
    }

    // fetching all the manager
    @Override
    public List<Manager> getallmanager() {
        List<Manager>  allmanager=this.repo.findAll();
        return allmanager;
    }

    // fetching the manager by id
    @Override
    public Manager getmanagerbyid(int id) {
        Manager man = this.repo.findById(id).get();
        return man;
    }

    // fetching the manager by name
    @Override
    public Manager getmanagerbyname(String name) {
        List<Manager> allman = this.repo.findAll();

        for (Manager man1 : allman) {
            if (man1.getName().equalsIgnoreCase(name)) {
                return man1;
            }
        }
        return null;
    }

    // fetching all managers by age
    @Override
    public List<Manager> getallmanagerbyage(int age) {
        List<Manager> allman = this.repo.findAll();

        List<Manager> commonagedemanager = allman.stream().filter(man -> man.getAge() == age)
                .collect(Collectors.toList());

        return commonagedemanager;
    }

    // fetching all managers by city
    @Override
    public List<Manager> getallmanagerbycity(String city) {
        List<Manager> allman = this.repo.findAll();

        List<Manager> commonmanager = allman.stream().filter(man -> man.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        return commonmanager;
    }

    // fetching all managers by dept
    @Override
    public List<Manager> getallmanagerbydept(String dept) {
        List<Manager> allman1 = this.repo.findAll();

        List<Manager> commonmanager = allman1.stream().filter(man -> man.getDept().equalsIgnoreCase(dept))
                .collect(Collectors.toList());
        return commonmanager;
    }

    // fetching all managers by company
    @Override
    public List<Manager> getallmaManagersbycompany(String company) {
        List<Manager> allman1 = this.repo.findAll();

        List<Manager> commonmanager = allman1.stream().filter(man -> man.getCompany().equalsIgnoreCase(company))
                .collect(Collectors.toList());
        return commonmanager;
    }

}
