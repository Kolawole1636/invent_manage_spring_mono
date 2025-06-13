package com.softcodemath.ProvisionInventoryManagement.repository;

import com.softcodemath.ProvisionInventoryManagement.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer> {


    UserInfo findByUserName(String username);
}
