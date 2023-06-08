package com.stas.stas_CRUD.controller;

import com.stas.stas_CRUD.entity.User;
import com.stas.stas_CRUD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user-service")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        if (id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var user = userService.getUserByID(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserByAll() {
        var user = userService.getAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/create/user", method = RequestMethod.POST)
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        userService.deleteUserByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@RequestBody User user) {
        var update = userService.updateUser(user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


}
