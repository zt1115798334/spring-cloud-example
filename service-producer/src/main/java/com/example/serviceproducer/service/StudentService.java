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

    /**
     * 保存
     * @param student 学生
     */
    void save(Student student);

    /**
     * 删除
     * @param id id
     */
    void del(Long id);

    /**
     * 查询全部
     * @return 学生集合
     */
    List<Student> findAll();

    /**
     * 查询
     * @param id id
     * @return 学生
     */
    Student findById(Long id);

}
