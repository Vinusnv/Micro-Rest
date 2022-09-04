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

import com.microservice.microserviceproject.ENTITY.User;
import com.microservice.microserviceproject.SERVICE.UserService;

@RestController
@RequestMapping("/micro/user/")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public ResponseEntity<User> CreateUser(@RequestBody User user) {

        User user2 = this.service.createUser(user);
        return new ResponseEntity<User>(user2, HttpStatus.CREATED);

    }
@GetMapping("/all")
    public ResponseEntity< List<User> > getAllUser()
    {

       List<User> alluser=this.service.getAllUser();
        try {
            return new ResponseEntity<List<User>>(alluser, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
       
        
    }

    @GetMapping("/{uid}")
    public ResponseEntity<User> singleUser(@PathVariable("uid") int id) {

        User user = this.service.getSingleUser(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @GetMapping("/byname")
    public User getUserByname(@RequestParam(value = "name") String name) {
        User user = this.service.getuserbyname(name);
        return user;
    }

    @GetMapping("/specificage")
    public List<User> specificageuser(@RequestParam(value = "age") int age) {
        List<User> userlist = this.service.getalluserbyspecificage(age);
        return userlist;
    }

    @GetMapping("/specificcity")
    public ResponseEntity<User> getUserByCity(@RequestParam(value = "city")String city)
    {
      User user=this.service.getUserBycity(city);
        return new  ResponseEntity<User>(user, HttpStatus.FOUND);

    }

    @PutMapping("update/{id}")
    public  ResponseEntity< User > updateUser(@PathVariable("id") int id, @RequestBody User user) {

        User user1 = this.service.updateUser(id, user);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id)
    {
        this.service.deleteUser(id);
    }

}
