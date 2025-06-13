package com.softcodemath.ProvisionInventoryManagement.service;

import com.softcodemath.ProvisionInventoryManagement.configuration.UserDataDetails;
import com.softcodemath.ProvisionInventoryManagement.entity.UserInfo;
import com.softcodemath.ProvisionInventoryManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userRepo.findByUserName(username);

        if (user==null){

            throw new UsernameNotFoundException("UserInfo not found");
        }

        return new UserDataDetails(user);


    }



}
