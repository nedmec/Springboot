package com.example.springboot.Dao;

import com.example.springboot.Entity.Course;
import com.example.springboot.Entity.Student;
import com.example.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ICourseDao extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query("update Course s set s.name=?1 where s.id=?2")
    int UpdateCourseNameById(String name, Long id);

    @Transactional
    @Modifying
    @Query("delete from Course s  where s.id=?2")
    int DeleteCourseById(Long id);

    Course findCourseByName(String name);
}
