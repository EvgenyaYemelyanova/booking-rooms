package com.example.bookingrooms.controller;

import com.example.bookingrooms.entity.Customer;
import com.example.bookingrooms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable("id") long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@PathVariable("id") long customerId, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCustomer(@PathVariable("id") long customerId) {
        customerService.deleteCustomer(customerId);
        return("Customer deleted successfully");
    }
}
