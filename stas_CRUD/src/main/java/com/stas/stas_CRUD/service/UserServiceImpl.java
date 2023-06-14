package com.stas.stas_CRUD.service;

import com.stas.stas_CRUD.entity.User;
import com.stas.stas_CRUD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByID(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        User result;

        var userId = user.getId();

        if (Objects.nonNull(userId) && userId != 0) {
            result = user;

            userRepository.save(result);

            System.out.println(String.format("Данные пользователя с id: %d обновлены!",
                    user.getId()));
        } else {
            result = userRepository.save(user);

            System.out.println(String.format("Новый пользовател с id: %d создан!",
                    result.getId()));
        }

        return result;
    }

    @Override
    public void deleteUserByID(Integer id) {
        userRepository.deleteById(id);

        System.out.println(String.format("Пользователь с id: %d удален!", id));
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }
}
