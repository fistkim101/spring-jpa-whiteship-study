package com.fistkim.springjpawhiteshipstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        List<Team> teams = teamRepository.findAll();
        teams.forEach(team -> System.out.println(team.getMembers().size()));
    }

}
