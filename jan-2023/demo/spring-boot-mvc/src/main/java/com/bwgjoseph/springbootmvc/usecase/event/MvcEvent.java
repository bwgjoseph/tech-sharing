package com.bwgjoseph.springbootmvc.usecase.event;

import org.springframework.context.ApplicationEvent;

public class MvcEvent extends ApplicationEvent {
    private String message;

    public MvcEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
