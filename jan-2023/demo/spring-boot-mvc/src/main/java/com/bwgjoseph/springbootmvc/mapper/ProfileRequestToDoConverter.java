package com.bwgjoseph.springbootmvc.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bwgjoseph.springbootmvc.models.ProfileRequest;
import com.bwgjoseph.springbootmvc.profile.Profile;

// spring automatic register the converter if annotated
@Component
public class ProfileRequestToDoConverter implements Converter<ProfileRequest, Profile> {

    @Override
    @Nullable
    public Profile convert(ProfileRequest source) {
        return Profile.builder()
            .name(source.name())
            .description(source.description())
            .build();
    }
    
}
