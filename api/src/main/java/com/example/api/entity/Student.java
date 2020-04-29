package com.example.api.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 16:36
 * description:
 */
@Data
public class Student {

    protected Long id;

    protected String name;

    protected String sex;

    protected LocalDate birth;

    protected String department;

    protected String address;

    protected LocalDateTime createdTime;
}
