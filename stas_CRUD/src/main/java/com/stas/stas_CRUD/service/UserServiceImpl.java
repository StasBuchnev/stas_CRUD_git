package com.stas.stas_CRUD.service;

import com.stas.stas_CRUD.entity.User;
import com.stas.stas_CRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByID(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User saveUser(User user) {
        var newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserByID(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }
}
