package com.bwgjoseph.techsharing.config;

import com.bwgjoseph.techsharing.post.PostService;
import com.bwgjoseph.techsharing.profile.ProfileService;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

/**
 * First Example
 *
 * Demo on how to manually create the bean, and use AnnotationConfigApplicatioContext
 * to grab the bean and use it
 *
 * See {@link https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-dependencies}
 * See {@link https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java-injecting-imported-beans}
 */
// @Configuration // Part 3
public class ApplicationConfig {
    // Part 1
    @Bean
    public ProfileService profileService(PostService postService, ApplicationEventPublisher publisher) {
        return new ProfileService(postService, publisher);
    }

    // Part 1, 2
    @Bean(initMethod = "init", destroyMethod = "bdestroy")
    public PostService postService() {
        return new PostService();
    }

    // Part 2
    @Bean
    public CustomBeanProcessor customBeanProcessor() {
        return new CustomBeanProcessor();
    }
}