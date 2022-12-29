package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Member> members = new HashSet<>();

}
