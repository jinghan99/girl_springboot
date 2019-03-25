package com.yf.mongo.dto;

import com.yf.mongo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Package com.yf.mongo.dto
 * @Description: TODO
 * @author: jingh
 * @date 2019/3/25 11:39
 */
@Component
public class MongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void saveStudent(Student student){
        mongoTemplate.save(student,"student");

    }

    public List<Student>  findAll(){
        return mongoTemplate.findAll(Student.class,"student");
    }
}
