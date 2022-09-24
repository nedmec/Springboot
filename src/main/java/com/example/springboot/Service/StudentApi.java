package com.example.springboot.Service;

import com.example.springboot.Dao.IStudentDao;
import com.example.springboot.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public boolean registerStudent(@RequestBody Student stu) {
        try {
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @PutMapping("/update")
    public boolean updateStudent(@RequestBody Student stu){
        try {
            sDao.save(stu);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @DeleteMapping("/delete")
    public boolean deleteStudent(@RequestParam Long id){
        try {
            sDao.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
