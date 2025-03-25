package com.softcodemath.ProvisionInventoryManagement.controller;


import com.softcodemath.ProvisionInventoryManagement.dto.ProductRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Category;
import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import com.softcodemath.ProvisionInventoryManagement.service.CategoryService;
import com.softcodemath.ProvisionInventoryManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ProductController {


    @Autowired
    private ProductService productService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("product")
    public Product createProduct(@RequestBody ProductRequest productRequest){

        return productService.createProduct(productRequest);


    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable int id){

        return productService.getProduct(id);


    }


}
