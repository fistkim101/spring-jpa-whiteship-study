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

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<Member> members = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(Member member) {
        this.members.add(member);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Set<Member> getMembers() {
        return members;
    }
}
