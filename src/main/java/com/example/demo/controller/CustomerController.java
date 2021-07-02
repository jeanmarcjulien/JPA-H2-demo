package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @PostMapping("/Customer")
    public Customer create(@RequestBody Customer customer){
        return this.customerRepository.save(customer);
        //return new Customer("John","Smith");
    }

    @GetMapping("/Customer")
    public Iterable<Customer> getAll(){
        return this.customerRepository.findAll();
    }

    @GetMapping("/Customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return this.customerRepository.findById(id);
    }

    @DeleteMapping("Customer/{id}")
    public Optional<Customer> deleteCustomerById(@PathVariable Long id){
        //this.customerRepository.deleteById(id);
        this.customerRepository.deleteById(id);
        return this.customerRepository.findById(id);
    }

    @PutMapping("Customer/{id}")
    public Customer updateCustomerById(@PathVariable Long id,@RequestBody Customer customer){
        Customer newCustomer = this.customerRepository.findById(id).get();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        return this.customerRepository.save(newCustomer);
    }

    @GetMapping("/CustomerByName/{lastName}")
    public List<Customer> getCustomerById(@PathVariable String lastName){
        return this.customerRepository.findByLastName(lastName);
    }

}

//CREATE
//READ
//UPDATE
//DELETE
//LIST

