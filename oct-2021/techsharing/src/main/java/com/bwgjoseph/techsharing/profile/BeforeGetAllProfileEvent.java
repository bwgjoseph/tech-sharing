package com.bwgjoseph.techsharing.profile;

import org.springframework.context.ApplicationEvent;

public class BeforeGetAllProfileEvent extends ApplicationEvent {
    private final String content;

    public BeforeGetAllProfileEvent(Object source, String content) {
        super(source);
        this.content = content;
    }
}
