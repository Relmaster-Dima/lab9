package com.taxi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int id;
    private String name;
    private String pass;
    private String role;

    // getters and setters
}
