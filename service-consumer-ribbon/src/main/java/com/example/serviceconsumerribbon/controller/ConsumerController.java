package com.example.serviceconsumerribbon.controller;

import com.example.api.entity.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 9:35
 * description:
 */
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    private final HttpHeaders httpHeaders;

    private final static String URL = "http://SERVICE-PRODUCER/";

    public ConsumerController(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @GetMapping("message")
    public String message() {
        return restTemplate.exchange(URL + "message", HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class).getBody();
    }

    @GetMapping("showName")
    public String showName(@RequestParam("name") String name) {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("name", name);
        return restTemplate.exchange(URL + "showName", HttpMethod.POST, new HttpEntity<>(requestBody, httpHeaders), String.class).getBody();
    }

    @GetMapping("findStudentAll")
    public List<Student> findStudentAll() {
        Student[] body = restTemplate.exchange(URL + "findStudentAll", HttpMethod.GET, new HttpEntity<>(httpHeaders), Student[].class).getBody();
        assert body != null;
        return Arrays.asList(body);

    }
}
