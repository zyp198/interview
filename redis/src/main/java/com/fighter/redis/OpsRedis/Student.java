package com.fighter.redis.OpsRedis;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
