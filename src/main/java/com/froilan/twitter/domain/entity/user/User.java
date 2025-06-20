package com.froilan.twitter.domain.entity.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
public class User implements UserDetails {

    @Id
    @NotBlank(message = "ID cannot be blank")
    @Field("id")
    private String id;

    @Id
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    @Field("user_name")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    @Field("password")
    private String password;

    @NotBlank(message = "Birthdate cannot be blank")
    @Field("birth_date")
    private Date birthDate;

    @Field("followers")
    @DBRef(lazy = true)
    private List<User> followers;

    @Field("following")
    @DBRef(lazy = true)
    private List<User> following;

    @Field("blocked_users")
    @DBRef(lazy = true)
    private List<User> blockedUsers;

    @Field("last_active")
    private Instant lastActive;

    @Field("profile")
    private Profile profile;

    @Field("settings")
    private Settings settings;

    @Field("stats")
    private Stats stats;

    @Field("created_at")
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    public List<User> getFollowing() {
        return following;
    }

    public List<User> getFollowers() {
        return followers;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
}
