package com.bwgjoseph.springbootmvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bwgjoseph.springbootmvc.mapper.ProfileMapperImpl;
import com.bwgjoseph.springbootmvc.profile.Profile;
import com.bwgjoseph.springbootmvc.profile.ProfileController;
import com.bwgjoseph.springbootmvc.profile.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @WebMvcTest only loads a specific configuration (i.e @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver beans but not @Component, @Service or @Repository beans)
 *
 * Purpose of a Controller test is to test the interaction with the Controller layer
 *
 * 1. Request Mapping
 * 2. Serialization
 * 3. Validation
 * 4. Deserialization
 * 5. Error Handling
 *
 * Ref: https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html
 */
@WebMvcTest(ProfileController.class)
@Import(ProfileMapperImpl.class)
class ProfileControllerTests {
    // using WebMvcTest will auto-configure MockMvc component
    // fakes http request
    @Autowired
    private MockMvc mockMvc;

    // we are not interested in collaborator class
    @MockBean
    private ProfileService profileService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void findAll() throws Exception {
        // Given
        Pageable pageable = PageRequest.of(0, 20);
        Profile profile = Profile.builder().id("1").name("joseph").description("description").version(0L).build();
        when(profileService.findAll(pageable)).thenReturn(new PageImpl<>(List.of(profile)));

        // content-type header defines the format of the data (useful for client/server)
        // accept header is for client to tell server what response it can accept (for client)

        // when
        this.mockMvc.perform(
            get("/api/v1/profiles")
                .param("page", "0")
                .param("size", "20")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // then
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content.size()").value("1"))
                .andDo(print());
    }

    @Test
    void findOne() throws Exception {
        // Given
        Profile profile = Profile.builder().id("1").name("joseph").description("description").version(0L).build();
        when(profileService.findById(profile.getId())).thenReturn(profile);

        // when
        this.mockMvc.perform(
            get("/api/v1/profiles/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // then
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andDo(print());
    }

    @Test
    void create() throws Exception {
        // Given
        Profile profile = Profile.builder().id("1").name("joseph.gan").description("description").version(0L).build();
        when(profileService.create(any(Profile.class))).thenReturn(profile);

        String requestBody = """
                {
                    "id": "1",
                    "name": "joseph",
                    "description": "description",
                    "version": 0
                }
                """;

        this.mockMvc.perform(
            post("/api/v1/profiles")
                .content(objectMapper.writeValueAsString(profile))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()) // then
                .andExpect(header().string("location", "/api/v1/profiles/1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andDo(print());
    }

    @Test
    void updateOne() throws JsonProcessingException, Exception {
        // Given
        Profile profile = Profile.builder().id("1").name("joseph.gan").description("description").version(0L).build();
        when(profileService.updateOne(any(Profile.class))).thenReturn(profile);

        // When
        this.mockMvc.perform(
            put("/api/v1/profiles/{id}", "1")
                .content(objectMapper.writeValueAsString(profile))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // then
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andDo(print());
    }

    @Test
    void deleteOne() throws Exception {
        // Given
        Profile profile = Profile.builder().id("1").name("joseph.gan").description("description").version(0L).build();
        when(profileService.deleteOne("1")).thenReturn(profile);

        // When
        this.mockMvc.perform(
            delete("/api/v1/profiles/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // then
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andDo(print());
    }

    @Test
    void validation() throws Exception {
        // Given
        Profile profile = Profile.builder().id("1").name("joseph").description("description").version(0L).build();
        when(profileService.create(any(Profile.class))).thenReturn(profile);

        this.mockMvc.perform(
            post("/api/v1/profiles")
                .content(objectMapper.writeValueAsString(profile))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest()) // then
                .andDo(print());
    }

    @Test
    void errorHandling() throws Exception {
        this.mockMvc.perform(
            get("/api/v1/profiles/profile-exception")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andDo(print());
    }

    @Test
    void argResolver() throws Exception {
        this.mockMvc.perform(
            get("/api/v1/profiles/secret-value")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("overwrite.secret.value"))
            .andDo(print());
    }
}
