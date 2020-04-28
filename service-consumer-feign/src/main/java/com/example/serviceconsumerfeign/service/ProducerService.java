package com.example.serviceconsumerfeign.service;

import com.example.serviceconsumerfeign.service.fallback.ProducerServiceFallbackFactory;
import com.example.serviceproducer.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 11:01
 * description:
 */
@FeignClient(name = "SERVICE-PRODUCER",
        configuration = FeignClientConfig.class,
        fallbackFactory = ProducerServiceFallbackFactory.class)
public interface ProducerService {

    @GetMapping("message")
    String message();

    @PostMapping("showName")
    String showName(@RequestParam("name") String name);
}
