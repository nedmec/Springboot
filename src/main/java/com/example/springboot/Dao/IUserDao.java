package com.example.springboot.Dao;

import com.example.springboot.Entity.Student;
import com.example.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IUserDao extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User s set s.name=?1 where s.id=?2")
    int UpdateUserNameById(String name, Long id);

    @Transactional
    @Modifying
    @Query("delete from User s  where s.id=?2")
    int DeleteUserById(Long id);

    User  findUserByNameAndPassword(String name, String Password);
}
