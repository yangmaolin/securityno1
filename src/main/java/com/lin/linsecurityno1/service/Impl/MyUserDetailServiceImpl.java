package com.lin.linsecurityno1.service.Impl;

import com.lin.linsecurityno1.dao.PersonRepository;
import com.lin.linsecurityno1.dao.RoleRepository;
import com.lin.linsecurityno1.pojo.MyDetails;
import com.lin.linsecurityno1.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * security要求返回UserDetail对象，我们要自定义自己的UserDetails对象，
 * 并且在自己实现的UserDetailsService类中查找用户，并自己拼装好UserDetails对象返回给Security
 */
@Service
@Primary
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private PersonRepository personRepository;
    @Resource
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person p=personRepository.findByUsername(s);
        if(p==null){
            throw new UsernameNotFoundException("User: "+s+"  is not found!");
        }
        MyDetails md=new MyDetails(p.getUsername(), p.getPassword(),
                roleRepository.findAllById(Collections.singletonList(p.getRole_id())));
        return md;
    }

    //配置密码对象
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
