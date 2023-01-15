package com.bwgjoseph.springbootmvc.usecase.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationRunnerStartup implements ApplicationRunner {

    // differences is mainly the args (String vs ApplicationArguments)
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("running ApplicationRunnerStartup commands");
    }
    
}
