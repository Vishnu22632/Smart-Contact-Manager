package com.scm.entities;

import java.util.ArrayList;
import java.util.List;
import com.scm.enums.Providers;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    private String password;
    private String about;
    private String profilePic;
    private String phoneNumber;

    // Information
    private boolean enabled = false;
    private boolean emailVarified = false;
    private boolean phoneNumberVarified = false;

    // SELF, GOOGLE, FACEBOOK, TWITTER, LINKEDIN, GITHUB

    @Enumerated(EnumType.STRING)
    private Providers provider = Providers.SELF;

    private String provideruserId;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();


}