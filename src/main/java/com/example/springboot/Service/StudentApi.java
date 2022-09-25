package com.example.springboot.Service;

import com.example.springboot.Dao.IStudentDao;
import com.example.springboot.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "学生管理相关接口")
@RequestMapping(value = "/student")
public class StudentApi {
    @Autowired
    private IStudentDao sDao;
    @GetMapping(value = "/login/{name}/{password}")
    public Student login(@PathVariable String name,@PathVariable String password) {
            Student stu = sDao.findStudentByNameAndPassword(name,password);
            if( stu == null) {
                return null;
            }
            else {
                return stu;
            }
    }
    @PostMapping(value = "/login")
    @ApiOperation("学生登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名",defaultValue = "admin",required = true),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "123456",required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = Student.class)
    })
    public Student login2(@RequestParam String name,@RequestParam String password) {
        Student stu = sDao.findStudentByNameAndPassword(name,password);
        if( stu == null) {
            return null;
        }
        else {
            return stu;
        }
    }
    @PostMapping(value = "/register")
    @ApiOperation("学生注册")
    @ApiImplicitParam(name = "stu",value = "学生用户JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean registerStudent(@RequestBody Student stu) {
        try {
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @PutMapping("/update")
    @ApiOperation("学生信息更新")
    @ApiImplicitParam(name = "stu",value = "新的学生用户JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean updateStudent(@RequestBody Student stu){
        try {
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @DeleteMapping("/delete")
    @ApiOperation("学生信息删除")
    @ApiImplicitParam(name = "id",value = "学生用户id",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean deleteStudent(@RequestParam Long id){
        try {
            sDao.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
