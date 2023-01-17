package com.bwgjoseph.springbootmvc.profile;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
@Document
@TypeAlias("profile")
public class Profile {
    @Id
    private String id;
    private String name;
    private String description;
    @Version
    private Long version;
}
