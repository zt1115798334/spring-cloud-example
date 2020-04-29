package com.example.serviceproducer.service.impl;

import com.example.serviceproducer.entity.Student;
import com.example.serviceproducer.repo.StudentRepository;
import com.example.serviceproducer.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeMBeanException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 17:01
 * description:
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void del(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("不存在"));
    }
}
