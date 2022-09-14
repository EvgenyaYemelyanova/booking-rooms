package com.example.bookingrooms.repositories;

import com.example.bookingrooms.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
