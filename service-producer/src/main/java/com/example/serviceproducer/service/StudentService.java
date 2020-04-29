package com.example.serviceproducer.service;

import com.example.serviceproducer.entity.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 17:00
 * description:
 */
public interface StudentService {

    void save(Student student);

    void del(Long id);

    List<Student> findAll();

    Student findById(Long id);

}
