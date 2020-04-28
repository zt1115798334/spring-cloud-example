package com.example.serviceconsumerribbon.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    public ConsumerController(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    @GetMapping("message")
    public String message() {
        String URL = "http://SERVICE-PRODUCER/";
        return restTemplate.exchange(URL + "message", HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class).getBody();
    }

    @GetMapping("showName")
    public String showName(@RequestParam("name") String name) {
        String URL = "http://SERVICE-PRODUCER/";
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("name", name);
        return restTemplate.exchange(URL + "showName", HttpMethod.POST, new HttpEntity<>(requestBody, httpHeaders), String.class).getBody();
    }
}
