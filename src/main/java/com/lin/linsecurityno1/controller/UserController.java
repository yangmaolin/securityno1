package com.lin.linsecurityno1.controller;

import com.lin.linsecurityno1.pojo.MyDetails;
import com.lin.linsecurityno1.service.Impl.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private MyUserDetailServiceImpl myUserDetailService;

    @RequestMapping("/login")
    public String login(@RequestParam("uname")String name, @RequestParam("upwd") String password){
        System.out.println("名字："+name+" , 密码："+password);
        UserDetails m= myUserDetailService.loadUserByUsername(name);
        System.out.println(m.getPassword());
        if(m.getPassword().equals(password)) {
            System.out.println("ok");
            return "/hello";
        }else{
            System.out.println("no ok");
            return "error";
        }
    }
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/index")
    public String tologin(){
        return "login";
    }
}
