package com.customers.demo.Service;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

}
