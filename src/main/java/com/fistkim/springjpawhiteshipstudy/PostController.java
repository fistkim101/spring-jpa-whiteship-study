package com.fistkim.springjpawhiteshipstudy;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/posts")
    public void testHandler(Pageable pageable){

    }

}
