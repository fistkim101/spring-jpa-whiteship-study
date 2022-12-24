package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AbstractAggregateRoot<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void registerEvent() {
        PostPublishedEvent postPublishedEvent = new PostPublishedEvent(this);
        this.registerEvent(postPublishedEvent);
    }

    public static Specification<Post> getPostsByCustomSpecification(String name, String description) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>(); // javax.persistence.criteria.Predicate;
            if (name != null) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }
            if (description != null) {
                predicates.add(criteriaBuilder.equal(root.get("description"), description));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
