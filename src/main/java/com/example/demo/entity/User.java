package com.example.demo.entity;  
  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;


@Entity
@Table(name = "user")

@Data
@Setter
@Getter
public class User {
    @Id  
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private Integer age; 
  

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer name) {
//        this.age = age;
//    }


}