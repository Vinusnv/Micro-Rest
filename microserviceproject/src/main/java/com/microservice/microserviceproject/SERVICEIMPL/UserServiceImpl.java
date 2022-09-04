package com.microservice.microserviceproject.SERVICEIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.microserviceproject.ENTITY.User;
import com.microservice.microserviceproject.REPOSITORY.UserRepo;
import com.microservice.microserviceproject.SERVICE.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Override
    public User createUser(User user) {

        User user2 = this.repo.save(user);
        return user2;
    }

    @Override
    public User updateUser(int id, User user) {
        User updateduser = this.repo.findById(id).get();
        updateduser.setAge(user.getAge());
        updateduser.setName(user.getName());
        updateduser.setCity(user.getCity());
        updateduser.setId(user.getId());
        

        

        return updateduser;
    }

    @Override
    public User getSingleUser(int id) {

        User user = this.repo.findById(id).get();

        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> alluser = this.repo.findAll();
        return alluser;
    }

   

    @Override
    public User getuserbyname(String name) {
        List<User> users = this.repo.findAll();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> getalluserbyspecificage(int age) {

        List<User> alluser = this.repo.findAll();

        List<User> specificuser = alluser.stream().filter(u -> u.getAge() == age).collect(Collectors.toList());
        return specificuser;
    }

    @Override
    public User getUserBycity(String city) {

        List<User> alluser = this.repo.findAll();

        User user1=null;

        for(User user :alluser)
        {
            if(user.getCity().equalsIgnoreCase(city))
            {

               user1=user;
            }
        }
        return user1;

        
    }
    @Override
    public void deleteUser(int id) {

        this.repo.deleteById(id);

    }

}
