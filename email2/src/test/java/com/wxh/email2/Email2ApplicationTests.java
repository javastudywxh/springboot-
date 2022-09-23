package com.wxh.email2;

import com.wxh.email2.entity.UserDetail;
import com.wxh.email2.entity.Users;
import com.wxh.email2.repo.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@SpringBootTest
class Email2ApplicationTests {
   // @Resource
   // AccountRepository repository;
    @Test
    void contextLoads() {
        //repository.findById(1).ifPresent(System.out::println);
      //repository.findAllByUsernameLike("%x%").forEach(System.out::println);
      //System.out.println(repository.findByIdAndAndUsername(1, "wxh"));
      //System.out.println(repository.existsUsersById(9));
    }
   /* @Transactional
    @Test
    void select(){
       *//* repository.findById(1).ifPresent(users -> {
            users.getScoreList().forEach(System.out::println);
        });*//*
      // repository.findById(1).ifPresent(System.out::println);
        //repository.findById(1).ifPresent(System.out::println);
        //repository.findAll().forEach(System.out::println);
        //repository.findAll(PageRequest.of(2,1)).forEach(System.out::println);
        repository.findById(1).ifPresent(users -> {
            users.getScoreList().forEach(score -> {
                System.out.println("课程名称：" + score.getSubject().getName());
                System.out.println("得分：" + score.getScore());
                System.out.println("任课教师:" + score.getSubject().getTeacher());
            });
        });
    }
    @Test
    void add(){
        Users users=new Users();
        users.setUsername("lbw");
        users.setPassword("123456");
        UserDetail detail=new UserDetail();
        detail.setAge(34);
        detail.setEmail("lbw@qq.com");
        detail.setMoney("100000w");
        users.setDetail(detail);
        users=repository.save(users);
        System.out.println("userId:"+users.getId()+"userDetailId:"+users.getDetail().getId());
    }
    @Test
    void delete(){
        repository.deleteById(3);
       // repository.deleteById(3);
    }
    @Test
    @Transactional
    void lazy(){
        repository.findById(1).ifPresent(users ->{
                    System.out.println(users.getUsername());
                    System.out.println(users.getDetail());
                });
    }
   @Test
    void update(){
        repository.updatePassWordById(1,"23456");
   }*/
}
