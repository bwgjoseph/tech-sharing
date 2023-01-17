package com.bwgjoseph.springbootmvc.models;

import lombok.Builder;

// lombok now supports @Builder at Record
@Builder
public record ProfileResponse(String id, String name, String description, Long version) {
}
