package com.customers.demo.ServiceImpl;

import org.springframework.stereotype.Service;

import com.customers.demo.DTO.CustomerRequestDTO;
import com.customers.demo.DTO.CustomerResponseDTO;
import com.customers.demo.Entity.Customers;
import com.customers.demo.Entity.Notes;
import com.customers.demo.Repository.CustomerRepository;
import com.customers.demo.Repository.NotesRepository;
import com.customers.demo.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private NotesRepository notesRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, NotesRepository notesRepository) {
        this.customerRepository = customerRepository;
        this.notesRepository = notesRepository;
    }

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customers customer = new Customers();
        Notes notes = new Notes();

        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();

        customer.setName(customerRequestDTO.getName());
        customer.setContact(customerRequestDTO.getContact());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setGstin(customerRequestDTO.getGstin());
        customer.setCreated_at(System.currentTimeMillis());

        notes.setNote_key(customerRequestDTO.getNotes().getNote_key());

        Customers savedCustomer = customerRepository.save(customer);
        Notes savedNotes = notesRepository.save(notes);

        customerResponseDTO.setId(savedCustomer.getId());
        customerResponseDTO.setName(savedCustomer.getName());
        customerResponseDTO.setContact(savedCustomer.getContact());
        customerResponseDTO.setEmail(savedCustomer.getEmail());
        customerResponseDTO.setGstin(savedCustomer.getGstin());
        customerResponseDTO.setCreated_at(savedCustomer.getCreated_at());
        customerResponseDTO.setNotes(savedNotes);

        return customerResponseDTO;
    }

}
