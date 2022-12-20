package com.fistkim.springjpawhiteshipstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@SpringBootApplication
public class SpringJpaWhiteshipStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaWhiteshipStudyApplication.class, args);
    }

}
