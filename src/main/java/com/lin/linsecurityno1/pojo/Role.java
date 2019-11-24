package com.lin.linsecurityno1.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色权限表，本demo以一对多为例，现实开发中为多对多，所以需要另外生成两个关联表
 */
@Entity
@Table(name="role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;
    private String shuoming;

    public String getRoleName(){
        return roleName;
    }
}
