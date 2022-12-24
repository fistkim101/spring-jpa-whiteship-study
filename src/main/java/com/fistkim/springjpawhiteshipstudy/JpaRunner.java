package com.fistkim.springjpawhiteshipstudy;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;


@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Post post = new Post();
        post.setName("specificationPostName");
        post.setDescription("specificationPostDescription");
        postRepository.save(post);


    }

}
