package com.bwgjoseph.techsharing.profile;

import com.bwgjoseph.techsharing.post.PostService;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final PostService postService;
    private final ApplicationEventPublisher publisher;

    public ProfileService(PostService postService, ApplicationEventPublisher publisher) {
        this.postService = postService;
        this.publisher = publisher;
    }

    public int getAllProfilePost(int profileId) {
        this.publisher.publishEvent(new BeforeGetAllProfileEvent(this, "BeforeGetAllProfileEvent"));
        return this.postService.findById(profileId);
    }
}
