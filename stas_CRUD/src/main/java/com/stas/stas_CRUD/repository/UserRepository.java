package com.stas.stas_CRUD.repository;

import com.stas.stas_CRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByAge(Byte age);
}
