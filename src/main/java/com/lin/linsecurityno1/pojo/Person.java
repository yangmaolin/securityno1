package com.lin.linsecurityno1.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户表，这里演示为一个用户对应一个权限，一个权限对应多个用户
 */
@Entity
@Table(name="person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    //用户对应的权限id，对应权限表里的id属性
    private Integer role_id;

    public String getUsername(){
        return  username;
    }
    public String getPassword(){
        return password;
    }
    public Integer getRole_id(){
        return role_id;
    }
}
