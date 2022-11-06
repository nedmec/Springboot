package com.example.springboot;

import com.example.springboot.Dao.IUserDao;
import com.example.springboot.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;
    @Test
    public void insertUser() {
        User stu = new User();
        stu.setAge(18);
        stu.setName("小明");
        stu.setPassword("123456");
        stu.setSex(true);
        userDao.save(stu);//新增
    }
    @Test
    public void findUserList(){
        List<User> students =userDao.findAll();
        System.out.println(students.size());//查找
    }
    @Test
    public void loginTest(){
        User stu = userDao.findUserByNameAndPassword("小明","123456");
        System.out.println(stu.getName());//登录
    }
    @Test
    public void updateNameById(){
        Integer Result = userDao.UpdateUserNameById("小明2",1l);
        System.out.println(Result);//修改


    }
}
