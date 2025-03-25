package com.softcodemath.ProvisionInventoryManagement.controller;


import com.softcodemath.ProvisionInventoryManagement.dto.OrderRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Customer;
import com.softcodemath.ProvisionInventoryManagement.entity.Order;
import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import com.softcodemath.ProvisionInventoryManagement.service.CustomerService;
import com.softcodemath.ProvisionInventoryManagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest){

        return orderService.createOrder(orderRequest);


    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("order/{id}")
    public Order getProduct(@PathVariable int id){

        return orderService.getOrder(id);


    }



}
