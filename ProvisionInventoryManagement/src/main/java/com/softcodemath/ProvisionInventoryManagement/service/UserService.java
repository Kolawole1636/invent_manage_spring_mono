package com.softcodemath.ProvisionInventoryManagement.service;


import com.softcodemath.ProvisionInventoryManagement.entity.UserInfo;
import com.softcodemath.ProvisionInventoryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserInfo newUser(UserInfo user) {

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);


    }


    public List<UserInfo> getUsers() {

        return userRepo.findAll();

    }
}
