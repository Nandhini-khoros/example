package com.example.SpringTest.controller;

import com.example.SpringTest.dao.UserDao;
import com.example.SpringTest.dao.UserDaoClass;
import com.example.SpringTest.model.User;
//import com.example.SpringTest.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
//@RequestMapping(value="/Customers")
public class UserController {

    UserDao userdao;


    public UserController() {
        userdao = new UserDaoClass();
    }

    //getall

    @RequestMapping(value = "/getall")
    public String getall() throws SQLException {

        return userdao.getAll().toString();

    }


    //getone

    @GetMapping(value = "/getone/{id}")
    public String getone(@PathVariable int id) throws SQLException {

        return userdao.getone(id).toString();

    }


    //Create new or POST

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public void create(@RequestBody User user) throws SQLException {

        userdao.create(user);

    }


    //update

    @RequestMapping(method = RequestMethod.PUT, value = "/put/{id}")
    public void update(@RequestBody User user, @PathVariable String id) throws SQLException {

        userdao.update(user, id);

    }


    //deleteone

    @GetMapping(value = "/delete/{id}")
    public int ser(@PathVariable int id) throws SQLException {

        return userdao.delete(id);

    }
}