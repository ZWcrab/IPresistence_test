package com.custom.dao;

import com.custom.pojo.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    User findByOne(User user);

    void createUser(User user);

    void updateUser(User user);

    void deleteById(User user);


}
