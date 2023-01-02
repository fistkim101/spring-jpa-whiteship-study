package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Version
    private Integer version;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

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

    public List<Member> getMembers() {
        return members;
    }
}
