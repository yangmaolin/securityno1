package com.lin.linsecurityno1.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http)throws  Exception {
        http.formLogin().loginPage("/index")
                .loginProcessingUrl("/login")
                .successForwardUrl("/hello")
                .and()
                .authorizeRequests()
                .antMatchers("/index","/login","/error").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
