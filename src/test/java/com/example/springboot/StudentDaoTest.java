package com.example.springboot;

import com.example.springboot.Dao.IStudentDao;
import com.example.springboot.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
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
        sDao.save(stu);//新增
    }
    @Test
    public void findStudentList(){
        List<Student> students =sDao.findAll();
        System.out.println(students.size());//查找
    }
    @Test
    public void loginTest(){
        Student stu = sDao.findFirstByNameAndPassword("小杨","123456");
        System.out.println(stu.getName());//登录
    }
    @Test
    public void updateNameById(){
        Integer Result = sDao.UpdateStudentNameById("小明2",1l);
        System.out.println(Result);//修改


    }
    @Test
    public void delete(){
        Integer Result = sDao.deleteStudentByName("小刚");
        System.out.println(Result);
    }

    @Test
    public void getAll(){
        List<Student> s=sDao.findStudentsBySexBetween(false,true);
        Iterator iterator = s.iterator();
        //通过while循环遍历，判断下一个是否有元素
        while (iterator.hasNext()) {
            //返回下一个元素
            Student e = (Student) iterator.next();
            System.out.println(" "+e.getName());
        }
    }
}
