package com.Hall.Lawn.Booking.System.Api.Entity;

import com.Hall.Lawn.Booking.System.Api.Enums.HallType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="halls")
public class Halls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_id")
    private Long id;
    @Column(name="hall_name",length = 150,nullable = false)
    @NotBlank(message = "Hall name is required")
    private String name;
    @Column(name="description",length = 150)
    private String description;
    private String location;
    private Long price_per_hour;
    private Long price_per_day;
    private Long capacity;
    private HallType halltype;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "halls",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hall_Images> images=new ArrayList<>();

    private Date created;
    private Date updated;

    @PrePersist
    protected void onCreated(){
        Date now = new Date();
        created = now;
        updated = now;
    }
    @PreUpdate
    protected void onUpdated(){
        Date now = new Date();
        updated = now;
    }

}
