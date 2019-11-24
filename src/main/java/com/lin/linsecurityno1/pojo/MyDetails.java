package com.lin.linsecurityno1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class MyDetails implements UserDetails {
    private String username;
    private String password;
    private List<Role> roles;

    //自定义构造函数，方便UserDetailsService实现类构造返回的UserDetails
    public MyDetails(String username,String password,List<Role> roles){
        this.username=username;
        this.password=password;
        this.roles=roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles.isEmpty())return Collections.EMPTY_LIST;
        else {
            return roles.parallelStream().map(role ->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
