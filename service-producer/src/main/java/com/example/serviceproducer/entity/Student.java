package com.example.serviceproducer.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 16:58
 * description:
 */
@Data
@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String name;

    protected String sex;

    protected LocalDate birth;

    protected String department;

    protected String address;

    protected LocalDateTime createdTime;

}
