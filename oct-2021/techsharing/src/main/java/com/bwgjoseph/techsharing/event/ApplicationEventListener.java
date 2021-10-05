package com.bwgjoseph.techsharing.event;

import com.bwgjoseph.techsharing.profile.ProfileService;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // Part 3
@RequiredArgsConstructor // Part 3
public class ApplicationEventListener implements ApplicationListener<ApplicationReadyEvent> {
    // Part 3
    private final ProfileService profileService;

    @EventListener(ApplicationReadyEvent.class)
    public void on(ApplicationReadyEvent event) {
        this.profileService.getAllProfilePost(10);
        log.info("Received event {}", event);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("From onApplicationEvent {}", event);
    }
}
