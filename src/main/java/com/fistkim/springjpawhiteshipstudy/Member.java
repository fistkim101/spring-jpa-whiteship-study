package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(referencedColumnName = "id")
    private Team team;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.addMember(this);
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }
}
