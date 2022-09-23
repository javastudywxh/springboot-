package com.wxh.email2.repo;

import com.wxh.email2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @Auther: WXH
 * @Date: 2022/9/19 - 09 - 19 - 21:21
 */
@Repository
public interface AccountRepository extends JpaRepository<Users,Integer> {
       /*List<Users> findAllByUsernameLike(String username);
       Users findByIdAndAndUsername(int id,String username);
       boolean existsUsersById(int id);
       @Transactional
       @Modifying
       @Query("update Users set password=?2 where id=?1")
       int updatePassWordById(int id,String password);*/
       Users findUsersByUsername(String username);
       @Transactional
       @Modifying
       @Query("update Users set password=?2 where username=?1")
       int updatePassWordByUsername(String username,String password);
}
