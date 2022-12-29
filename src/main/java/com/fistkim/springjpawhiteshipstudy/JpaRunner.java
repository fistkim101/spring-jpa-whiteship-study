package com.fistkim.springjpawhiteshipstudy;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Album album = new Album();
        album.setName("아이템이름");
        album.setPrice(10000);
        album.setSinger("가수이름");

        entityManager.persist(album);
    }

}
