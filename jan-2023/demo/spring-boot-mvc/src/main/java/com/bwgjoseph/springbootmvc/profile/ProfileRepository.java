package com.bwgjoseph.springbootmvc.profile;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// @Repository - no longer required to declare
public interface ProfileRepository extends MongoRepository<Profile, String> {

    /**
     * This is what we call `Derived Query Method`
     * See https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#repositories.query-methods.details
     */
    List<Profile> findByName(String name);

}
