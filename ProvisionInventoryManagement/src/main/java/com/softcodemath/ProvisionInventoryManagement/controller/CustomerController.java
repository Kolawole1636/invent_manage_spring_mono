package com.softcodemath.ProvisionInventoryManagement.controller;


import com.softcodemath.ProvisionInventoryManagement.dto.ProductRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Customer;
import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import com.softcodemath.ProvisionInventoryManagement.service.CustomerService;
import com.softcodemath.ProvisionInventoryManagement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@Tag(name="Customer Management APIs")
public class CustomerController {



    @Autowired
    private CustomerService customerService;


    @Operation(
            summary = "Create New Customer",
            description = "Creating new customer"
    )

    @ApiResponse(

            responseCode = "201",
            description = "Http Status 201 Created"

    )

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("customer")

    public Customer createCustomer(@RequestBody Customer customer){

        return customerService.createCustomer(customer);


    }


    @Operation(
            summary = "Fetching a customer",
            description = "Fetching a specific customer through his or her id"
    )

    @ApiResponse(

            responseCode = "201",
            description = "Http Status 201 Created"

    )


    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable int id){

        return customerService.getCustomer(id);


    }


    @GetMapping("customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();


    }

}
