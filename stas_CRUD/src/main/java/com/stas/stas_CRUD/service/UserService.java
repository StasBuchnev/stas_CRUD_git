package com.stas.stas_CRUD.service;

import com.stas.stas_CRUD.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserByID(Integer id);

    User saveUser(User user);

    void deleteUserByID(Integer id);

    List<User> getAllUser();

}
