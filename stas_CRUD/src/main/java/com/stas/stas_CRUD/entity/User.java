package com.stas.stas_CRUD.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    private Integer id;
    private String name;
    private String firstName;
    private Byte age;

}
