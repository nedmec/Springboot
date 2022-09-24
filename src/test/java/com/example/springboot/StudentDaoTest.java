package com.example.springboot;

import com.example.springboot.Dao.IStudentDao;
import com.example.springboot.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class StudentDaoTest {
    @Autowired
    private IStudentDao sDao;

    @Test
    public void insertStudent() {
        Student stu =new Student();
        stu.setAge(18);
        stu.setName("小明");
        stu.setPassword("123456");
        stu.setSex(true);
        sDao.save(stu);
    }
    @Test
    public void findStudentList(){
        List<Student> students =sDao.findAll();
        System.out.println(students.size());
    }
    @Test
    public void loginTest(){
        Student stu = sDao.findStudentByNameAndPassword("小明","123456");
        System.out.println(stu.getName());
    }
    @Test
    public void updateNameById(){
        Integer Result = sDao.UpdateStudentNameById("小明2",1l);
        System.out.println(Result);


    }
}
