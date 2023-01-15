package com.bwgjoseph.springbootmvc.profile;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bwgjoseph.springbootmvc.exception.ProfileException;
import com.bwgjoseph.springbootmvc.exception.ProfileResponseStatusException;

import lombok.RequiredArgsConstructor;

// Combination of @Controller and @ResponseBody
@RestController
@RequiredArgsConstructor
// Request handler mapping
// @Get, @Post, @Put, @Patch, @Delete Mapping are an alias for this
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping
    public List<Profile> findAll() {
        return this.profileService.findAll();
    }

    @GetMapping("/{id}")
    // no need to specify value if name matches
    public Profile findOne(@PathVariable String id) {
        return this.profileService.findById(id);
    }

    @PostMapping
    public Profile create(@RequestBody Profile profile) {
        return this.profileService.create(profile);
    }

    @PutMapping("/{id}")
    public Profile updateOne(@RequestBody Profile profile) {
        return this.profileService.updateOne(profile);
    }

    @PatchMapping("/{id}")
    public Profile patchOne(@RequestBody Profile profile) {
        return this.profileService.updateOne(profile);
    }

    @DeleteMapping("/{profileId}")
    // explicit map to the pathvariable since it does not match argName
    public Profile deleteOne(@PathVariable("profileId") String id) {
        return this.profileService.deleteOne(id);
    }

    @GetMapping("/by-name")
    public List<Profile> findBy(@RequestParam("name") String name) {
        return this.profileService.findByName(name);
    }

    @GetMapping("/exception")
    public void exception() {
        throw new RuntimeException("default exception");
    }

    @GetMapping("/response-status-exception")
    public void responseStatusException() {
        throw new ProfileResponseStatusException();
    }

    @GetMapping("/profile-exception")
    public void profileException() {
        throw new ProfileException("profile exception");
    }

    @ExceptionHandler(ProfileException.class)
    public String handlePerException() {
        return "handle profile exception";
    }
}
