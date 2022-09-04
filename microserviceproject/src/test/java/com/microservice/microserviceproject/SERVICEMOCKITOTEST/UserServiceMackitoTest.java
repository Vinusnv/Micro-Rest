package com.microservice.microserviceproject.SERVICEMOCKITOTEST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.microserviceproject.ENTITY.User;
import com.microservice.microserviceproject.REPOSITORY.UserRepo;
import com.microservice.microserviceproject.SERVICEIMPL.UserServiceImpl;

@SpringBootTest(classes = { UserServiceMackitoTest.class })
public class UserServiceMackitoTest {

    @Mock
    UserRepo userRepo;

    List<User> user;

    public User user2;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    @Order(1)
    public void test_getAlluser()

    {
        List<User> user = new ArrayList<User>();

        user.add(new User(10, 26, "vinay", "shimogga"));

        when(userRepo.findAll()).thenReturn(user);
        assertEquals(1, userServiceImpl.getAllUser().size());

    }

    @Test
    @Order(2)
    public void test_getsingleuser() {

        User user = new User(2, 10, "vinay", "banglore");
int id=2;
       

when(userRepo.findById(2).get()).thenReturn(user);

assertEquals(id, userServiceImpl.getSingleUser(id));

    }

    @Test
    @Order(3)
    public void test_getuserbyname() {

        List<User> list = new ArrayList<User>();
        list.add(new User(10, 20, "vinay", "shimogga"));

        String name = "vinay";
        when(userRepo.findAll()).thenReturn(list);

        assertEquals(name, userServiceImpl.getuserbyname(name).getName());

    }

    @Test
    @Order(4)
    public void test_getalluserbyspecificage() {

        List<User> list = new ArrayList<User>();

        list.add(new User(10, 20, "vinay", "shimogga"));
        list.add(new User(10, 20, "vinay", "shimogga"));
        list.add(new User(10, 30, "vinay", "shimogga"));
        list.add(new User(10, 30, "vinay", "shimogga"));

        int age = 20;
        when(userRepo.findAll()).thenReturn(list);

        assertEquals(2, userServiceImpl.getalluserbyspecificage(age).size());

    }
@Test
@Order(5)
    public void test_createuser()
    {
        User user=new User(10, 20, "vinay", "shimogga");

  when(userRepo.save(user)).thenReturn(user);

  assertEquals(user, userServiceImpl.createUser(user)) ;

    }
@Test
@Order(6)
    public void test_updateUser()
    {

        int id=10;
                User user=new User(id, 25, "name", "city");

            //    User upd=userRepo.findById(id).get();

             
    }


    @Test
    @Order(5)
    public void  test_deleteUser()
    {

        int id=10;
        User user=new User(10, 20, "hh", "shimogga");

        userServiceImpl.deleteUser(id);
        verify(userRepo,times(1)).deleteById(id);

    }
    
@Test
@Order(7)
    public void test_getuserbycity()
    {

        String city="hyderbad";

        List<User> user=new ArrayList<User>();
        user.add(new User(10, 26, "vinay", "hyderbad"));

        when(userRepo.findAll()).thenReturn(user);

        
assertEquals(city, userServiceImpl.getUserBycity(city).getCity());
    }

}
