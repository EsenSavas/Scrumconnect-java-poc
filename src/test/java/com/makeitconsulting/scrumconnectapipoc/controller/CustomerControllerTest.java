package com.makeitconsulting.scrumconnectapipoc.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeitconsulting.scrumconnectapipoc.dto.request.CustomerRequest;
import com.makeitconsulting.scrumconnectapipoc.dto.response.CustomerResponse;
import com.makeitconsulting.scrumconnectapipoc.service.CustomerService;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.logging.Logger;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private final static Logger logger = Logger.getLogger(CustomerControllerTest.class.getName());

    @Test
    void whenValidInput_thenReturns201() throws Exception {
        CustomerRequest user = new CustomerRequest("Esen", "female", 1, "UK");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenValidInput_thenReturns400() throws Exception {
        CustomerRequest user = new CustomerRequest("Esen", "female", 1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidInput_thenReturnsUserName() throws Exception {

        CustomerRequest customerRequest = new CustomerRequest("Esen", "female", 1, "UK");

        CustomerResponse customerResponse = new CustomerResponse(customerRequest.getName());
        when(customerService.saveCustomer(any())).thenReturn(customerResponse);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerRequest)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Esen")))
                .andReturn();

    }

    @Test
    void whenNullValue_thenReturns400AndErrorResult() throws Exception {
        CustomerRequest customerRequest = new CustomerRequest("Esen", "female", 1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/save")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customerRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(StringContains.containsString("Please provide country")))
                .andReturn();

    }
}
