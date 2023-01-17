package com.bwgjoseph.springbootmvc.profile;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Page<Profile> findAll(Pageable pageable) {
        return this.profileRepository.findAll(pageable);
    }

    public Profile findById(String id) {
        return this.profileRepository.findById(id).get();
    }

    public Profile create(Profile profile) {
        return this.profileRepository.insert(profile);
    }

    public Profile updateOne(Profile profile) {
        return this.profileRepository.save(profile);
    }

    public Profile deleteOne(String id) {
        Profile profile = this.profileRepository.findById(id).get();
        this.profileRepository.deleteById(id);

        return profile;
    }

    public List<Profile> findByName(String name) {
        return this.profileRepository.findByName(name);
    }   
}
