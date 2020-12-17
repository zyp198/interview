package com.fighter.redis.OpsRedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        Student stu = new Student(1, "Bob");
        redisTemplate.opsForValue().set("stu",stu);
        System.out.println(redisTemplate.opsForValue().get("stu"));
    }
}
