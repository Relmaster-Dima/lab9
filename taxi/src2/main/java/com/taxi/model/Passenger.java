package com.taxi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passenger {
    @Id
    private int passengerId;
    private String name;
    private String phoneNumber;
    private String email;
    private boolean deleted;

    // getters and setters
}
