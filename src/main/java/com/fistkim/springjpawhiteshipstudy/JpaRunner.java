package com.fistkim.springjpawhiteshipstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class JpaRunner implements ApplicationRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Post post = new Post();
        post.setName("포스트이름");
        post.setDescription("포스트상세설명");
        postRepository.save(post);

        // List<Post> targets = postRepository.findByNameLike("포스트이름");
        List<Post> targets = postRepository.findByNameLike("포스트상세설명");
        System.out.println(">>> " + targets.size());
    }
}
