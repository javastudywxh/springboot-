package com.wxh.email2.Service;


/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 15:02
 */
public interface VerifyService {
    void sendVerifyCode(String mail);
    boolean doVerify(String mail,String code);
    void sendNotNullVerifyCode(String mail,String username);
}
