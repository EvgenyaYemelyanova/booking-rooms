package com.example.bookingrooms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "building")
@Data
@NoArgsConstructor
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String addressBuilding;
    @Enumerated(EnumType.STRING)
    @NotNull
    private TypeBuilding typeBuilding;
    @NotNull
    private String floorBuilding;
    @OneToMany(mappedBy = "building")
    private List<Apartment> apartment;

}
