package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post as p where p.description like :description")
    List<Post> findByNameLike(@Param(value = "description") String description);
}
