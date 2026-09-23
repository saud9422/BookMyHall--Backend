package com.Hall.Lawn.Booking.System.Api.Entity;

import com.Hall.Lawn.Booking.System.Api.Enums.Gender;
import com.Hall.Lawn.Booking.System.Api.Enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String address;
    private String phone;
    private Role role;
    private Boolean isActive = true;
    private Date createdOn;
    private Date updatedOn;
    private Gender gender;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Halls> halls = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        createdOn = now;
        updatedOn = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }
}

