package com.fistkim.springjpawhiteshipstudy;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PostEventListener implements ApplicationListener<PostPublishedEvent> {

    @Override
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("================");
        System.out.println("name >>> " + event.getPost().getName());
        System.out.println("description >>> " + event.getPost().getDescription());
        System.out.println("================");
    }

}
