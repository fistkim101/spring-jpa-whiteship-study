package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
