package com.makeitconsulting.scrumconnectapipoc.service;

import com.makeitconsulting.scrumconnectapipoc.dto.response.CustomerResponse;
import com.makeitconsulting.scrumconnectapipoc.model.Customer;
import com.makeitconsulting.scrumconnectapipoc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse saveCustomer(Customer customer) {
        Customer returnedCustomer = customerRepository.save(customer);
        return CustomerResponse.builder().name(returnedCustomer.getName()).build();
    }
}
