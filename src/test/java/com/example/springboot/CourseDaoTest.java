package com.example.springboot;

import com.example.springboot.Dao.ICourseDao;
import com.example.springboot.Entity.Course;
import com.example.springboot.Entity.Student;
import com.example.springboot.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseDaoTest {
    @Autowired
    private ICourseDao courseDao;
    @Test
    public void insertCourse() {
        Course stu = new Course();
        stu.setNumber(50);
        stu.setName("数据结构");

        courseDao.save(stu);//新增
    }
    @Test
    public void findUserList(){
        List<Course> students =courseDao.findAll();
        System.out.println(students.size());//查询
    }
    @Test
    public void loginTest(){
        Course stu = courseDao.findCourseByName("数据结构与算法");
        System.out.println(stu.getName());//登录
    }
    @Test
    public void updateNameById(){
        Integer Result = courseDao.UpdateCourseNameById("小明2",1l);
        System.out.println(Result);//修改


    }
}
