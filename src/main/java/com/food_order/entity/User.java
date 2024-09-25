package com.food_order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.food_order.dto.RestaurantDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String fullName;

    String email;

    String password;

    USER_ROLE role =USER_ROLE.ROLE_CUSTOMER;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    List<Order> orders = new ArrayList<>();
    @ElementCollection
    List<RestaurantDto> favorites = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<Address> addresses = new ArrayList<>();
}
