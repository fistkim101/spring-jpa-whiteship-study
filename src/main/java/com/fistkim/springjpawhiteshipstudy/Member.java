package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Team team;

}
