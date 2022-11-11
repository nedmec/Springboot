package com.example.springboot.Service;

import com.example.springboot.Dao.IStudentDao;
import com.example.springboot.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@Api(tags = "学生管理相关接口")
@CrossOrigin(allowedHeaders = {"*"})
@RequestMapping(value = "/student")
public class StudentApi {
    @Autowired
    private IStudentDao sDao;
    @GetMapping(value = "/login/{name}/{password}")
    public Student login(@PathVariable String name,@PathVariable String password) {
            Student stu = sDao.findFirstByNameAndPassword(name,password);
        return stu;
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
        Student stu = sDao.findFirstByNameAndPassword(name,password);
        return stu;
    }
    @PostMapping(value = "/register")
    @ApiOperation("学生注册")
    @ApiImplicitParam(name = "stu",value = "学生用户JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public Student registerStudent(@RequestBody Student stu) {
        try {
            sDao.save(stu);

        }catch (Exception e){
            return stu;
        }return stu;
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
    @ApiImplicitParam(name = "name",value = "学生用户名",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean deleteStudent(@RequestParam String name){
        try {
            sDao.deleteStudentByName(name);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @PutMapping("/update2")
    public boolean updateStudent2(String name,Long id){
        try {
            sDao.UpdateStudentNameById(name,id);
        }catch (Exception e){
            return false;
        }return true;
    }

    @PostMapping("/getAll")
    @ApiOperation("获取所有学生信息")
    @ApiResponse(code = 200,message = "操作成功",response = String.class)
    public String getAll(){
        String s1="";
        try {
            List<Student> s=sDao.findStudentsBySexBetween(false,true);

            Iterator iterator = s.iterator();
            while (iterator.hasNext()) {
                Student e = (Student) iterator.next();
                s1=s1.concat(",");
                s1=s1.concat(e.getName());
            }

        }catch (Exception e){
            return s1;
        }
        return s1;
    }
}
