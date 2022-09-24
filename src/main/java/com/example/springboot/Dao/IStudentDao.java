package com.example.springboot.Dao;

import com.example.springboot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IStudentDao extends JpaRepository<Student,Long> {
    Student findStudentByNameAndPassword(String name,String password);
    Student findStudentById(Long id);

    @Transactional
    @Modifying
    @Query("update Student s set s.name=?1 where s.id=?2")
    int UpdateStudentNameById(String name, Long id);
}
