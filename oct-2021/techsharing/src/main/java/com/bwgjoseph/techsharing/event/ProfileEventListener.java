package com.bwgjoseph.techsharing.event;

import com.bwgjoseph.techsharing.profile.BeforeGetAllProfileEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProfileEventListener {
    @EventListener(BeforeGetAllProfileEvent.class)
    public void on(BeforeGetAllProfileEvent event) {
        log.info("event {}", event);
    }
}
