package com.bwgjoseph.springbootmvc.usecase.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MvcEventListener {
    // an alternate way to listen to event, other than implementing ApplicationListener
    @EventListener(MvcEvent.class)
    public void handle(MvcEvent mvcEvent) {
        log.info("source: {}, message: {}", mvcEvent.getSource(), mvcEvent.getMessage());
    }
}
