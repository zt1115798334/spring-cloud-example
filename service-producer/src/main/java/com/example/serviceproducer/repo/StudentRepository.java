package com.example.serviceproducer.repo;

import com.example.serviceproducer.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 16:59
 * description:
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
}
