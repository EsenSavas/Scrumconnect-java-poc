package com.makeitconsulting.scrumconnectapipoc.service;

import com.makeitconsulting.scrumconnectapipoc.dto.response.CustomerResponse;
import com.makeitconsulting.scrumconnectapipoc.model.Customer;
import com.makeitconsulting.scrumconnectapipoc.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    void whenValidInput_thenReturns201() throws Exception {
        Customer customer = new Customer("Esen", "Female", 1, "UK", new Date());
        when(customerRepository.save(customer)).thenReturn(customer);
        CustomerResponse customerResponse = customerService.saveCustomer(customer);
        assertEquals("Esen", customerResponse.getName());
        verify(customerRepository, times(1)).save(customer);
    }
}