package com.makeitconsulting.scrumconnectapipoc.repository;

import com.makeitconsulting.scrumconnectapipoc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
