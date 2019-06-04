package com.juebingliu.boot4learn.domain.third;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author juebing
 * @date 2018/12/4 19:00
 * @description
 */
@Entity
@Table(name = "person", schema = "health-plat", catalog = "")
public class PersonEntity implements Serializable {
    private static final long serialVersionUID = 4324133632787899690L;
    private long id;
    private int age;
    private String name;

    public PersonEntity(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public PersonEntity() {
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id == that.id &&
                age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}