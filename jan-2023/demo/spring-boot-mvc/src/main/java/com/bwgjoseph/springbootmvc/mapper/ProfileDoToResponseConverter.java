package com.bwgjoseph.springbootmvc.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.bwgjoseph.springbootmvc.models.ProfileResponse;
import com.bwgjoseph.springbootmvc.profile.Profile;

// spring automatic register the converter if annotated
@Component
public class ProfileDoToResponseConverter implements Converter<Profile, ProfileResponse> {

    @Override
    @Nullable
    public ProfileResponse convert(Profile source) {
        return ProfileResponse.builder()
            .id(source.getId())
            .name(source.getName())
            .description(source.getDescription())
            .version(source.getVersion())
            .build();
    }
    
}
