package com.example.serviceconsumerfeign.controller;

import com.example.api.entity.Student;
import com.example.serviceconsumerfeign.service.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 11:05
 * description:
 */
@RestController
public class ConsumerController {

    private final ProducerService producerService;

    public ConsumerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("message")
    public String message() {
        return producerService.message();
    }

    @PostMapping("showName")
    public String showName(@RequestParam("name") String name) {
        return producerService.showName(name);
    }

    @GetMapping("findStudentAll")
    public List<Student> findStudentAll() {
        return producerService.findStudentAll();
    }
}
