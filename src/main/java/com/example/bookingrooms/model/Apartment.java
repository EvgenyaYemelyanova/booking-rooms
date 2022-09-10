package com.example.bookingrooms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "apartment")
@Data
@NoArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String floor;
    @NotNull
    private String squareMeters;
    @Column(columnDefinition = "text")
    @NotNull
    private String description;
    @ManyToOne()
    private Building building;
    @ManyToOne()
    private Customer customer;

}
