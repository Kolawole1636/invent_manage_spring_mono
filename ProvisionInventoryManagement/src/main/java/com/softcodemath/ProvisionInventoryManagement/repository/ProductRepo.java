package com.softcodemath.ProvisionInventoryManagement.repository;

import com.softcodemath.ProvisionInventoryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);
    boolean existsById(int id);
    Product findByName(String name);


}
