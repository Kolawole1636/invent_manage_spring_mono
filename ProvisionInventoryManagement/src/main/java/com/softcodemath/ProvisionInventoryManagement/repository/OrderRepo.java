package com.softcodemath.ProvisionInventoryManagement.repository;

import com.softcodemath.ProvisionInventoryManagement.dto.OrderRequest;
import com.softcodemath.ProvisionInventoryManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
