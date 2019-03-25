package com.yf.mongo.controller;

import com.yf.mongo.dto.MongoDao;
import com.yf.mongo.entity.Student;
import com.yf.mongo.entity.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package com.yf.mongo.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/3/25 11:47
 */
@RestController
public class MongoTestController {
    @Autowired
    private MongoDao mongoDao;

    @GetMapping("/save")
    public void save() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("hzb：" + i);
            student.setSex("man：" + i);
            student.setAge(i);
            student.setDes("hzb_father：" + i);
            StudentScore score = new StudentScore();
            score.setChinese("88：" + i);
            score.setEnglish("93：" + i);
            score.setDes("hzb_child");
            student.setStudentScore(score);
            mongoDao.saveStudent(student);
        }


    }
    @GetMapping("/findAll")
    public List<Student> findAll() {
        return mongoDao.findAll();
    }
}
