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
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setName("fistkim");
        entityManager.persist(account);

        Study study = new Study();
        study.setName("spring data study");
        study.setOwner(account);
        account.getStudies().add(study);
        entityManager.persist(study);
    }
}
