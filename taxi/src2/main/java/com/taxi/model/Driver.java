package com.taxi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {
    @Id
    private int driverId;
    private String name;
    private String phoneNumber;
    private String email;
    private String licenseNumber;
    private boolean deleted;

    // getters and setters
}
