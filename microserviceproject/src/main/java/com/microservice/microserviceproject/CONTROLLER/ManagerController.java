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

import com.microservice.microserviceproject.ENTITY.Manager;
import com.microservice.microserviceproject.SERVICEIMPL.ManagerServiceImpl;

@RestController
@RequestMapping("/micro/man/")
public class ManagerController {

    @Autowired
    private ManagerServiceImpl service;

    // creating all manager
    @PostMapping("/")
    public ResponseEntity<Manager> createmanager(@RequestBody Manager man) {

        Manager createdmanager = this.service.createmanager(man);

        return new ResponseEntity<Manager>(createdmanager, HttpStatus.CREATED);

    }

    // updating the manager
    @PutMapping("/update/{id}")
    public ResponseEntity<Manager> updatemanager(@PathVariable("id") int id, @RequestBody Manager man)

    {
        Manager updatedmanger = this.service.updatemanager(man, id);

        return new ResponseEntity<Manager>(updatedmanger, HttpStatus.CREATED);

    }

    // deleting the manager
    @DeleteMapping("/deletebyid")
    public ResponseEntity<Manager> deletemanager(@RequestParam(name = "id") int id) {
        Manager deletedman = this.service.deletemanager(id);

        return new ResponseEntity<Manager>(deletedman, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Manager>> getallmanager()
    {
        List<Manager>  allman=this.service.getallmanager();
        return new ResponseEntity<List<Manager>>(allman, HttpStatus.FOUND);
    }
    

    // fetching the manager by id
    @GetMapping("/getbyid")
    public ResponseEntity<Manager> getmanagerbyid(@RequestParam(name = "name") String name) {
        Manager man = this.service.getmanagerbyname(name);

        return new ResponseEntity<Manager>(man, HttpStatus.FOUND);
    }

    // fetching the manager by name
@GetMapping("/getbyname")
public ResponseEntity<Manager> getmanagerbyname(@RequestParam(name = "name")String name)
{
    Manager man1=this.service.getmanagerbyname(name);

    return new ResponseEntity<Manager>(man1, HttpStatus.FOUND);
}

    // fetching all managers by age
    @GetMapping("/getbyage")
    public ResponseEntity<List<Manager>> getallmanagerbyage(@RequestParam(name = "age") int age) {

        List<Manager> allman = this.service.getallmanagerbyage(age);

        return new ResponseEntity<>(allman, HttpStatus.FOUND);

    }

    // fetching all managers by city
    @GetMapping("/getbycity")
    public ResponseEntity<List<Manager>> getallmanagerbycity(@RequestParam(name = "city") String city) {
        List<Manager> allman = this.service.getallmanagerbycity(city);

        return new ResponseEntity<List<Manager>>(allman, HttpStatus.FOUND);
    }

    // fetching all managers by dept
    @GetMapping("/getbydept")
    public ResponseEntity<List<Manager>> getallmanagerbydept(@RequestParam(name = "dept") String dept) {
        List<Manager> allman = this.service.getallmanagerbydept(dept);

        return new ResponseEntity<List<Manager>>(allman, HttpStatus.FOUND);
    }

    // fetching all managers by company
    @GetMapping("/getbycompany")
    public ResponseEntity<List<Manager>> getallmaManagersbycompany(@RequestParam(name = "company") String company) {
        List<Manager> allman = this.service.getallmanagerbydept(company);

        return new ResponseEntity<List<Manager>>(allman, HttpStatus.FOUND);
    }

}
