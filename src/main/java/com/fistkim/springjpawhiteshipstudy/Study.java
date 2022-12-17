package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @ManyToOne
//    private Account owner;

}
