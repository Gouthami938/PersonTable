package com.ivy.training.jpademo1.PersonSecurityConfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

@Configuration
public class PersonConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .rememberMe().userDetailsService(userDetailsService)
                .and()

                .httpBasic();




    }
}
