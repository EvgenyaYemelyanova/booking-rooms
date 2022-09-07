package com.example.bookingrooms.service.impl;

import com.example.bookingrooms.model.Customer;
import com.example.bookingrooms.exception.CustomerNotFoundException;
import com.example.bookingrooms.repositories.CustomerRepository;
import com.example.bookingrooms.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );
    }

    @Override
    public Customer updateCustomer(long id, Customer newCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );

        customer.setFirstName(newCustomer.getFirstName());
        customer.setLastName(newCustomer.getLastName());
        customer.setPassword(newCustomer.getPassword());
        customer.setEmail(newCustomer.getEmail());

        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Customer with id '%d' not found", id))
        );
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(0, 10));
        return customers.toList();
    }
}
