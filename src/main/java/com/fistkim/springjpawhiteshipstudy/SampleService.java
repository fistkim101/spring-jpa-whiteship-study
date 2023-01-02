package com.fistkim.springjpawhiteshipstudy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class SampleService {

    @PersistenceContext
    private EntityManager entityManager;

    private final TeamRepository teamRepository;

    public SampleService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public Team check() {
        System.out.println(">>> service entityManager : " + entityManager);

        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        System.out.println(">>> service isNewTransaction : " + status.isNewTransaction());

        Team team = new Team();
        team.setName("teamName");

        Member member = new Member();
        member.setName("sampleMember");
        member.setTeam(team);

        return teamRepository.findById(1L).get();
    }

}
