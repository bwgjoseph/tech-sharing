package com.bwgjoseph.springbootmvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.bwgjoseph.springbootmvc.models.ProfileRequest;
import com.bwgjoseph.springbootmvc.models.ProfileResponse;
import com.bwgjoseph.springbootmvc.profile.Profile;

@Mapper(componentModel = ComponentModel.SPRING)
public interface ProfileMapper {
    Profile toDomainObject(ProfileRequest profileRequest);

    ProfileResponse toProfileDto(Profile profile);
}
