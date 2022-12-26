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
    private EntityManager entityManager1;

    @PersistenceContext
    private EntityManager entityManager2;


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>>>>");
        System.out.println(entityManager1);
        System.out.println(entityManager2);
        System.out.println("<<<<<");
    }

}
