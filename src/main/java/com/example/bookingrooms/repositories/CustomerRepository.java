package com.example.bookingrooms.repositories;

import com.example.bookingrooms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
