package com.softcodemath.ProvisionInventoryManagement.controller;


import com.softcodemath.ProvisionInventoryManagement.entity.Category;
import com.softcodemath.ProvisionInventoryManagement.repository.CategoryRepo;
import com.softcodemath.ProvisionInventoryManagement.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@Tag(name="Category Management APIs")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(
            summary = "Create New Category",
            description = "Creating new category for the products"
    )

    @ApiResponse(

            responseCode = "201",
            description = "Http Status 201 Created"

    )

    @PostMapping("category")
    public Category createCategory(@RequestBody Category category){

        return categoryService.createCategory(category);


    }





}
