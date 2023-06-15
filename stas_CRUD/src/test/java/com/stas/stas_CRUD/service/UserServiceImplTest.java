package com.stas.stas_CRUD.service;


import static org.junit.jupiter.api.Assertions.*;

import com.stas.stas_CRUD.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceFullTest() {
        User user1 = new User();
        User user2 = new User();
        user1.setName("Петр");
        user1.setAge((byte) 29);
        user1.setFirstName("Иванов");
        user2.setName("Лиза");
        user2.setAge((byte) 31);
        user2.setFirstName("Палова");

        userService.saveUser(user1);
        userService.saveUser(user2);
        user1.setId(3);
        user2.setId(4);

        assertEquals(user1, userService.getUserByID(3));
        assertEquals(user2, userService.getUserByID(4));

        user2.setName("Иван");
        userService.saveUser(user2);
        assertEquals(user2, userService.getUserByID(4));

        assertEquals(2,userService.getAllUser().size());

        userService.deleteUserByID(3);
        userService.deleteUserByID(4);

        assertTrue(userService.getAllUser().isEmpty());

    }
}
