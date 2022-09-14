package com.example.bookingrooms.repositories;

import com.example.bookingrooms.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
