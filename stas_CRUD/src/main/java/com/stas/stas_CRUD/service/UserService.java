package com.stas.stas_CRUD.service;

import com.stas.stas_CRUD.entity.User;

import java.util.List;

public interface UserService {

    User getUserByID(Integer id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUserByID(Integer id);

    List<User> getAllUser();

}
