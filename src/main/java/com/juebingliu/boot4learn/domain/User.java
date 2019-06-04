package com.juebingliu.boot4learn.domain;

import java.io.Serializable;

/**
 * @author juebing
 * @date 2018/12/3 16:22
 * @description
 */
public class User implements Serializable {
    private static final long serialVersionUID = -4475917692661015333L;
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}