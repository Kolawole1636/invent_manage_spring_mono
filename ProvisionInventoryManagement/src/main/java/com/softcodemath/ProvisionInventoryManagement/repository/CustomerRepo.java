package com.softcodemath.ProvisionInventoryManagement.repository;

import com.softcodemath.ProvisionInventoryManagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {



}
