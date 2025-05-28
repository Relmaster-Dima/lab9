package com.taxi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поле name в БД
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Поле pass в БД
    @Column(name = "pass", nullable = false)
    private String pass;

    @Column(name = "role", nullable = false)
    private String role;

    public UserEntity() { }

    public UserEntity(String name, String pass, String role) {
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    // getters/setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
