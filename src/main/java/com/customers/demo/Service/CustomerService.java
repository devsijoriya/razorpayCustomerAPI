package com.customers.demo.Service;

import java.util.List;
import java.util.UUID;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO updateCustomer(UUID id, CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO getCustomer(UUID id);

    List<CustomerResponseDTO> fetchCustomer(int count, int skip);
}
