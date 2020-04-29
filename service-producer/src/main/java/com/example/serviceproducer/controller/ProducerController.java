package com.example.serviceproducer.controller;

import com.example.serviceproducer.entity.Student;
import com.example.serviceproducer.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/27 16:20
 * description:
 */
@RestController
public class ProducerController {

    @Value("${server.port}")
    private String port;

    private final StudentService studentService;

    public ProducerController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("message")
    public String message() {
        return "hello message，my port is：" + port;
    }

    @PostMapping("showName")
    @HystrixCommand(fallbackMethod = "showNameException")
    public String showName(@RequestParam("name") String name) {
        if (Objects.equals(name, "xiaoming")) {
            throw new RuntimeException("xiaoming is die");
        }
        return "hello, my name is " + name + "，my port is：" + port;
    }

    public String showNameException(@RequestParam("name") String name) {
        return name + " is over";
    }

    @GetMapping("findStudentAll")
    public List<Student> findStudentAll() {
        return studentService.findAll();
    }
}
