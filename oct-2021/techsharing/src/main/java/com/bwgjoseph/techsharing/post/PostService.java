package com.bwgjoseph.techsharing.post;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostService implements InitializingBean, DisposableBean {
    // @Autowired
    // private PostValidator validator;

    // @Autowired
    // private Validator validator2;

    public int findById(int profileId) {
        // Validator factory = Validation.buildDefaultValidatorFactory().getValidator();
        // Set<ConstraintViolation<Post>> violations = factory.validate(new Post(1, -1));

        // Set<ConstraintViolation<Post>> violations = validator2.validate(new Post(1, -1));

        // violations.forEach(v -> System.out.println(v.getMessage()));

        return new Random().nextInt(profileId);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("from postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("from afterPropertiesSet");
    }

    public void init() {
        log.info("from init");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("from preDestroy");
    }

    public void bdestroy() {
        log.info("from bdestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.info("from destroy");
    }
}
