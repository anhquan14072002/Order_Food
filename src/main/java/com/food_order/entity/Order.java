package com.food_order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    User customer;
    @ManyToOne
    @JsonIgnore
    Restaurant restaurant;

    Long totalAmount;

    String orderStatus;

    Date createdAt;
    @ManyToOne
    Address deliveryAddress;
    @OneToMany
    List<OrderItem> items;

    int totalItem;

    int totalPrice;

    //Payment payment;

}
