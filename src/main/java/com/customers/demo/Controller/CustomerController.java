package com.customers.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;
import com.customers.demo.Service.CustomerService;

@RestController
@RequestMapping("/v1")

public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerRequestDTO), HttpStatus.CREATED);
    }

}
