package com.bwgjoseph.techsharing.post;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Post.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "profileId", "profileId is not defined");
        Post post = (Post) target;

        if (post.getProfileId() < 5) {
            errors.rejectValue("profileId", "12345", "profileId < 5");
        }
    }

}
