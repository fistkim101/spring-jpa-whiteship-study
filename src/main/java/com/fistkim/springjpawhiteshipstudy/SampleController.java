package com.fistkim.springjpawhiteshipstudy;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class SampleController {

    @PersistenceContext
    private EntityManager entityManager;

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/check")
    public String sampleHandler() {
        System.out.println(">>> controller entityManager : " + entityManager);
        System.out.println(">>> controller before entityManager.isOpen() : " + entityManager.isOpen());

        TransactionStatus status = null;
        try {
            status = TransactionAspectSupport.currentTransactionStatus();
            System.out.println(">>> controller isNewTransaction : " + status.isNewTransaction());
        } catch (Exception exception) {
            System.out.println("before : not in transaction now ...");
        }

        // service logic
        Team team = sampleService.check();

        System.out.println(">>> controller after entityManager.isOpen() : " + entityManager.isOpen());

        System.out.println("================================");
        team.getMembers().forEach(member -> System.out.println(member.getName()));
        System.out.println("================================");

        try {
            status = TransactionAspectSupport.currentTransactionStatus();
            System.out.println(">>> controller isNewTransaction : " + status.isNewTransaction());
        } catch (Exception exception) {
            System.out.println("after : not in transaction now ...");
        }

        return "ok";
    }

}
