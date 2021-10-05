package com.bwgjoseph.techsharing.post;

import javax.validation.constraints.Min;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Post {
    @Min(5)
    private final int postId;
    private final int profileId;
}
