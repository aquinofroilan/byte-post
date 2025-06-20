package com.froilan.twitter.domain.entity.user;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

public class Profile {

    @NotBlank
    @Field("name")
    private String name;

    @Field("gender")
    private String gender;

    @Field("bio")
    private String bio;

    @Field("location")
    private String location;

    @Field("website")
    private String website;

    @Field("joined_date")
    private LocalDateTime joinedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }
}
