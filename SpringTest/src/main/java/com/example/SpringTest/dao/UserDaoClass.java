package com.example.SpringTest.dao;

import com.example.SpringTest.model.User;

import java.sql.*;
import java.sql.DriverManager;
import java.util.*;
import java.util.List;

public class UserDaoClass implements UserDao{





    List<User> users = new ArrayList<User>();

    Connection conc;

    {

        try {

            conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/heros", "root", "Goksravi99.");

        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }

    }





    //GETALL

    public List<User> getAll() throws SQLException {

        Statement stat= conc.createStatement();

        ResultSet res=stat.executeQuery(" select *  from user;");

        while(res.next()) {

            User user = new User();

            user.setId(res.getInt("id"));

            user.setName(res.getString("name"));

            users.add(user);

        }

        return users;

    }



    //GETONE WITH ID

    //@Override

    public List<User> getone(int id) throws SQLException {

        /*Userdata udi= new Userdataimpl();

        udi.getAll();

        users.stream() ;*/



        PreparedStatement stat = conc.prepareStatement("select * from user where id= ?");

        stat.setInt(1, id);

        ResultSet res = stat.executeQuery();

        while (res.next()) {

            User user = new User();

            user.setId(res.getInt("id"));

            user.setName(res.getString("name"));

            users.add(user);

        }

        return users;

    }



    //@Override

    public void create(User user) throws SQLException {

        PreparedStatement stat = conc.prepareStatement("insert into user (id,name) values(?,?)");

        stat.setInt(1, user.getId());

        stat.setString(2,user.getName());

        stat.executeUpdate();



    }



    //@Override

    public void update(User user, String id) throws SQLException {

        PreparedStatement stat = conc.prepareStatement(" UPDATE user SET name = ? WHERE id = ?;");

        stat.setString(1,user.getName());

        stat.setInt(2, Integer.parseInt(id));

        stat.executeUpdate();

    }





    //DELETE WITH ID

    //@Override

    public int delete(int id) throws SQLException {

        PreparedStatement stat = conc.prepareStatement("delete from user where id= ?;");
        stat.setInt(1, id);
        int res=stat.executeUpdate();
        return 0;

    }

}
