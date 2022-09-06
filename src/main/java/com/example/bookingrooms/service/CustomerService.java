package com.example.bookingrooms.service;

import com.example.bookingrooms.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);
    Customer getCustomerById(long id);
    Customer updateCustomer(long id, Customer customer);
    void deleteCustomer(long id);
    List<Customer> getAllCustomers();
}
