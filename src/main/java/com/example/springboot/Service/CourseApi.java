package com.example.springboot.Service;

import com.example.springboot.Dao.ICourseDao;
import com.example.springboot.Entity.Course;
import com.example.springboot.Entity.Student;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "课程管理相关接口")
@CrossOrigin(allowedHeaders = {"*"})
@RequestMapping(value = "/Course")
public class CourseApi {
    @Autowired
    private ICourseDao courseDao;
    @GetMapping(value = "/login/{name}/{password}")
    public Course login(@PathVariable String name, @PathVariable String password) {
        return courseDao.findCourseByName(name);
    }
    @PostMapping(value = "/login")
    @ApiOperation("课程查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "课程名",defaultValue = "admin",required = true),
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "操作成功",response = Student.class)
    })
    public Course login2(@RequestParam String name) {
        return courseDao.findCourseByName(name);
    }
    @PostMapping(value = "/register")
    @ApiOperation("课程增加")
    @ApiImplicitParam(name = "stu",value = "课程JSON数据",required = true)
    @ApiResponse(code = 200,message = "操作成功",response = Boolean.class)
    public boolean registerStudent(@RequestBody Course course) {
        try {
            courseDao.save(course);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
