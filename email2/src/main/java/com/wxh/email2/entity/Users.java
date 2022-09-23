package com.wxh.email2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 21:12
 */
@Data
@Entity
@Table(name = "users")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置为自增
    @Column(name = "id") //设置属性名
    @Id    //设置主键
    int id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "email")
    String email;
    /*@JoinColumn (name = "detailId")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    UserDetail detail;
    @JoinColumn(name = "uid")
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    List<Score> scoreList;*/
}
