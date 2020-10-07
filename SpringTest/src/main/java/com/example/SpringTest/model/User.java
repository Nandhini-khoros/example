package com.example.SpringTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;


public class User {


    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override

    public String toString() {

        return "User{" +

                "id=" + id +

                ", name='" + name +
                '}';

    }
    }
