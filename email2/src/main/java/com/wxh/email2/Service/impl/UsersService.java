package com.wxh.email2.Service.impl;

import com.wxh.email2.entity.Users;
import com.wxh.email2.repo.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 14:06
 */
@Service
public class UsersService implements UserDetailsService {
    @Resource
    AccountRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repository.findUsersByUsername(username);
        if (users==null) throw  new UsernameNotFoundException("用户不存在");
        return User
                .withUsername(users.getUsername())
                .password(users.getPassword())
                .roles("user")
                .build();
    }
}
