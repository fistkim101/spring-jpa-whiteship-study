package com.fistkim.springjpawhiteshipstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setName("첫번째 포스팅");
        postRepository.save(post);

    }
}
