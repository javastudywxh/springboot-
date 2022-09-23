package com.wxh.email2.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 10:05
 */
/*@Data
@Entity
@Table(name = "subjects")*/
public class Subject {
  /*  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    @Id
    int id;
    @Column(name = "name")
    String name;*/
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "tid")
    Teacher teacher;*/
 /* @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "teach_relation",
            joinColumns = @JoinColumn(name = "cid"),
            inverseJoinColumns = @JoinColumn(name = "tid"))
    List<Teacher> teacher;
    @Column(name = "period")
    String period;*/
}
