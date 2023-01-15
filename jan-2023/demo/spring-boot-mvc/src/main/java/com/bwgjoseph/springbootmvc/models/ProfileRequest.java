package com.bwgjoseph.springbootmvc.models;

import com.bwgjoseph.springbootmvc.validation.NameFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfileRequest(@NameFormat @NotBlank String name, @Size(min = 10) String description) {
    
}
