package com.softcodemath.ProvisionInventoryManagement.repository;

import com.softcodemath.ProvisionInventoryManagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
