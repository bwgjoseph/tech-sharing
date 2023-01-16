package com.bwgjoseph.springbootmvc.profile;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.bwgjoseph.springbootmvc.exception.ProfileException;
import com.bwgjoseph.springbootmvc.exception.ProfileResponseStatusException;
import com.bwgjoseph.springbootmvc.logging.LoggingAop;
import com.bwgjoseph.springbootmvc.mapper.ProfileMapper;
import com.bwgjoseph.springbootmvc.models.ProfileRequest;
import com.bwgjoseph.springbootmvc.models.ProfileResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

// Combination of @Controller and @ResponseBody
@RestController
@RequiredArgsConstructor
// Request handler mapping
// @Get, @Post, @Put, @Patch, @Delete Mapping are an alias for this
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @GetMapping
    public Page<Profile> findAll(@PageableDefault Pageable pageable) {
        return this.profileService.findAll(pageable);
    }

    @LoggingAop
    @GetMapping("/{id}")
    // no need to specify value if name matches
    public Profile findOne(@PathVariable String id) {
        return this.profileService.findById(id);
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> create(@Valid @RequestBody ProfileRequest profileRequest) {
        Profile convertedProfile = this.profileMapper.toDomainObject(profileRequest);
        Profile createdProfile = this.profileService.create(convertedProfile);

        UriComponents location = UriComponentsBuilder.newInstance()
            .path("/api/v1/profiles/{id}")
            .buildAndExpand(createdProfile.getId());

        return ResponseEntity
            .created(location.toUri())
            .body(this.profileMapper.toProfileDto(createdProfile));
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
    // interestingly, when using @ExceptionHandler for a specific exception, it does not
    // return the status code base on exception
    // and that we have to manually return it
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlePerException() {
        return "handle profile exception";
    }
}
