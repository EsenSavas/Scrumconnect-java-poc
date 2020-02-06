package com.makeitconsulting.scrumconnectapipoc.controller;

import com.makeitconsulting.scrumconnectapipoc.dto.request.CustomerRequest;
import com.makeitconsulting.scrumconnectapipoc.dto.response.CustomerResponse;
import com.makeitconsulting.scrumconnectapipoc.model.Customer;
import com.makeitconsulting.scrumconnectapipoc.service.CustomerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "customer")
class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "${CustomerController.saveCustomerData}")
    @ApiResponses(value = {//
            @ApiResponse(code = 500, message = "Something went wrong"), //
            @ApiResponse(code = 400, message = "Not Valid Data")})
    public ResponseEntity<CustomerResponse> saveCustomerData(@ApiParam("Customer") @Valid @RequestBody CustomerRequest customerDto, BindingResult result) throws MethodArgumentNotValidException, NoSuchMethodException {

        if (result.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(this.getClass().getDeclaredMethod("saveCustomerData", CustomerRequest.class, BindingResult.class), 0),
                    result);
        }
        Customer customer = new Customer(customerDto.getName(), customerDto.getSex(), customerDto.getAge(), customerDto.getCountry(), new Date());
        CustomerResponse response = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}