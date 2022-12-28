package com.fistkim.springjpawhiteshipstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void specificationTest() {
        Post post = new Post();
        final String NAME = "specificationPostName";
        final String DESCRIPTION = "specificationPostDescription";
        post.setName(NAME);
        post.setDescription(DESCRIPTION);
        postRepository.save(post);

        List<Post> targets = postRepository.findAll(Post.getPostsByCustomSpecification(NAME, null));
        Assertions.assertThat(targets.size()).isEqualTo(1);
        Assertions.assertThat(targets.get(0).getName()).isEqualTo(NAME);
        Assertions.assertThat(targets.get(0).getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    void saveTest() {
        Post post = new Post();
        post.setName("name_1");
        post.setDescription("description_1");
        Post savedPost = postRepository.save(post);

        Assertions.assertThat(entityManager.contains(post)).isTrue();
        Assertions.assertThat(entityManager.contains(savedPost)).isTrue();
        Assertions.assertThat(post).isEqualTo(savedPost);
    }

    @Test
    void updateTest() {
        Post post = new Post();
        post.setName("name_1");
        post.setDescription("description_1");
        postRepository.save(post);

        Post newPost = new Post();
        newPost.setId(1L);
        newPost.setName("new_name_1");
        newPost.setDescription("new_description_1");
        Assertions.assertThat(entityManager.contains(newPost)).isFalse();

        // merge 발생. 이 때 newPost의 복사본이 영속화된다.
        Post updatedPost = postRepository.save(newPost);

        // 파라미터로 넘긴 entity인 newPost 는 detached
        Assertions.assertThat(entityManager.contains(newPost)).isFalse();

        // update 결과로 받은 entity인 updatedPost는 persistent
        Assertions.assertThat(entityManager.contains(updatedPost)).isTrue();
    }

}
