package com.bwgjoseph.springbootmvc.usecase.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.bwgjoseph.springbootmvc.usecase.event.MvcEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationRunnerStartup implements ApplicationRunner {
    private final ApplicationEventPublisher applicationEventPublisher;

    // differences is mainly the args (String vs ApplicationArguments)
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("running ApplicationRunnerStartup commands");
        log.info("publishing mvc event");

        this.applicationEventPublisher.publishEvent(new MvcEvent(this, "mvc event"));
    }
    
}
