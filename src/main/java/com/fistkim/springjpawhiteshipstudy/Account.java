package com.fistkim.springjpawhiteshipstudy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public Set<Study> getStudies() {
        return studies;
    }
}
