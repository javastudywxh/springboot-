package com.wxh.email2.Service.impl;

import com.wxh.email2.Service.VerifyService;
import com.wxh.email2.repo.AccountRepository;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 15:03
 */
@Service
public class VerifyServiceImpl implements VerifyService {
    @Resource
    JavaMailSender sender;
    @Resource
    StringRedisTemplate template;
    @Resource
    AccountRepository repository;
    @Override
    public void sendVerifyCode(String mail) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setSubject("【wxh的网站】您的注册验证码");
        Random random=new Random();
        int code=random.nextInt(89999)+10000;
        template.opsForValue().set(mail,code+"",3, TimeUnit.MINUTES);
        message.setText("您的注册验证码为："+code+",三分钟内有效，请及时完成注册！如果不是本人操作，请忽略");
        message.setTo(mail);
        message.setFrom("javastudywxh@163.com");
        sender.send(message);
    }
    @Override
    public void sendNotNullVerifyCode(String mail,String username) {
        if((repository.findUsersByUsername(username).getEmail()).equals(mail)){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setSubject("【wxh的网站】您的请求验证码");
        Random random=new Random();
        int code=random.nextInt(89999)+10000;
        template.opsForValue().set(mail,code+"",3, TimeUnit.MINUTES);
        message.setText("您的修改验证码为："+code+",三分钟内有效，请及时完成密码的修改！如果不是本人操作，请忽略");
        message.setTo(mail);
        message.setFrom("javastudywxh@163.com");
        sender.send(message);
        }else {
            throw new UsernameNotFoundException("");
        }
    }
    @Override
    public boolean doVerify(String mail, String code) {
        String s = template.opsForValue().get(mail);
        if (s==null) return false;
        if (!s.equals(code)) return false;
        template.delete("verify:code:" +mail);
        return true;
    }
}
