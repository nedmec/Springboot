package com.example.springboot.Dao;

import com.example.springboot.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStudentDao extends JpaRepository<Student, Long> {
    Student findFirstByNameAndPassword(String name, String password);


    Student findStudentById(Long id);
    @Transactional
    @Modifying
    Integer deleteStudentByName(String name);
    @Transactional
    @Modifying
    Integer deleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query("update Student s set s.name=?1 where s.id=?2")
    int UpdateStudentNameById(String name, Long id);

    @Transactional
    @Modifying
    @Query("delete from Student s  where s.id=?2")
    int DeleteStudentById(Long id);

    @Transactional
    @Modifying
    @Query("select s from Student s where s.sex=?1 or s.sex=?2")
    List<Student> findStudentsBySexBetween(boolean sex1,boolean sex2);

}
