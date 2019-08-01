package com.example.demo.entity;

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

}