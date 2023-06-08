package com.stas.stas_CRUD.service;

import com.stas.stas_CRUD.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static int count = 1;
    private static ConcurrentHashMap<Integer, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User getUserByID(Integer id) {
        var user = userMap.get(id);

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User saveUser(User user) {
        user.setId(count);
        userMap.put(count, user);
        count = count + 1;
        return getUserByID(count - 1);
    }

    @Override
    public User updateUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUserByID(Integer id) {

        userMap.remove(id);
        System.out.println("Пользователь по id " + id + "удален");
    }

    @Override
    public List<User> getAllUser() {

        return userMap.entrySet().stream().map(integerUserEntry -> integerUserEntry.getValue()).collect(Collectors.toList());
    }
}
