package com.company.smis.model;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    @Column(name ="name",nullable = false,length = 255)
    private String name;

    public Department() {

    }


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department(Integer did, String name) {
        this.did = did;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }
}