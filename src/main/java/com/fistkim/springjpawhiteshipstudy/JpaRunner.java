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
        post.setName("queryDslTestName");
        post.setDescription("queryDslTestDescription");
        postRepository.save(post);

        QPost targetPost = QPost.post;
        Predicate predicate = targetPost
                .name.contains("DslTestN")
                .and(targetPost.description.contains("DslTestDes"));
        Optional<Post> target = postRepository.findOne(predicate);

        System.out.println("-----------------------");
        System.out.println(target.get().getName());
        System.out.println(target.get().getDescription());
        System.out.println("-----------------------");
    }

}
