package com.softcodemath.ProvisionInventoryManagement.service;

import com.softcodemath.ProvisionInventoryManagement.entity.Category;
import com.softcodemath.ProvisionInventoryManagement.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;


    public Category createCategory(Category category) {

        return categoryRepo.save(category);

    }
}
