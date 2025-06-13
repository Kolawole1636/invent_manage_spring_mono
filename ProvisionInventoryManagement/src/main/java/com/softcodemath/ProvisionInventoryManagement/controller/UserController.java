package com.softcodemath.ProvisionInventoryManagement.controller;

import com.softcodemath.ProvisionInventoryManagement.entity.UserInfo;
import com.softcodemath.ProvisionInventoryManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public UserInfo newUser(@RequestBody UserInfo user){

        return userService.newUser(user);


    }



    @GetMapping("getusers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserInfo> getUsers(){

        return userService.getUsers();

    }



}
