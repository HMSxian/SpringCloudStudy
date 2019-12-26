package com.hp.controller;

import com.hp.entity.UserInfo;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public String login(){
        System.out.println("mmm");
        return "success";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserInfo queryuserById(@PathVariable("id") Integer i){
        System.out.println(i);
        UserInfo userInfo=userService.selectUserById(i);
        System.out.println(userInfo);
        return userInfo;
    }
}
