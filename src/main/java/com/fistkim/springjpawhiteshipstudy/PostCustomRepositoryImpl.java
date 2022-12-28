package com.fistkim.springjpawhiteshipstudy;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Post findMyPost() {
        return entityManager.find(Post.class, 1L);
    }

}
