package com.wxh.email2.Service;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 12:33
 */
public interface UserService {
     void insertUser(String password,String username,String email);
     void updateUser(String username,String password);
}
