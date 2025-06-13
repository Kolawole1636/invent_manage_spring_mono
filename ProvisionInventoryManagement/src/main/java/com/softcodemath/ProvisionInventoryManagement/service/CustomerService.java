package com.softcodemath.ProvisionInventoryManagement.service;


import com.softcodemath.ProvisionInventoryManagement.entity.Customer;
import com.softcodemath.ProvisionInventoryManagement.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {

        return customerRepo.save(customer);


    }

    public Customer getCustomer(int id) {


        return customerRepo.findById(id).get();


    }

    public List<Customer> getCustomers() {


        return customerRepo.findAll();
    }
}
