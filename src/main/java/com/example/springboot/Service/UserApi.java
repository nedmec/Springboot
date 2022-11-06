package com.example.springboot.Service;

import com.example.springboot.Dao.IUserDao;
import com.example.springboot.Entity.Student;
import com.example.springboot.Entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理相关接口")
@CrossOrigin(allowedHeaders = {"*"})
@RequestMapping(value = "/User")
public class UserApi {
    @Autowired
    private IUserDao userDao;
    @GetMapping(value = "/login/{name}/{password}")
    public User login(@PathVariable String name, @PathVariable String password) {
        return userDao.findUserByNameAndPassword(name,password);
    }
    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",defaultValue = "admin",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "123456",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = Student.class)
    })
    public User login2(@RequestParam String name, @RequestParam String password) {
        return userDao.findUserByNameAndPassword(name,password);
    }
    @PostMapping(value = "/register")
    @ApiOperation("用户注册")
    @ApiImplicitParam(name = "stu",value = "用户JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean registerStudent(@RequestBody User user) {
        try {
            userDao.save(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @PutMapping("/update")
    @ApiOperation("用户信息更新")
    @ApiImplicitParam(name = "stu",value = "新的用户JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean updateStudent(@RequestBody User user){
        try {
            userDao.save(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @DeleteMapping("/delete")
    @ApiOperation("用户信息删除")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean deleteStudent(@RequestParam Long id){
        try {
            userDao.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
