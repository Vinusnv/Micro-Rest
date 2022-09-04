package com.microservice.microserviceproject.SERVICE;

import java.util.List;

import com.microservice.microserviceproject.ENTITY.User;

public interface UserService {

    public User createUser(User user);

    public User updateUser(int id,User user);

    public User getSingleUser(int id);

    public List<User> getAllUser();

    public void deleteUser(int id);

    public User getuserbyname(String name);

    public List<User> getalluserbyspecificage(int age);


    public User getUserBycity(String city);

}
