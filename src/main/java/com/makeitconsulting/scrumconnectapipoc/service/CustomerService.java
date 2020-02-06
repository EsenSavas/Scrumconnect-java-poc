package com.makeitconsulting.scrumconnectapipoc.service;

import com.makeitconsulting.scrumconnectapipoc.dto.response.CustomerResponse;
import com.makeitconsulting.scrumconnectapipoc.model.Customer;

public interface CustomerService {

    CustomerResponse saveCustomer(Customer customer);
}
