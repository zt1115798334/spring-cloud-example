package com.example.serviceconsumerfeign.service.fallback;

import com.example.api.entity.Student;
import com.example.serviceconsumerfeign.service.ProducerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang
 * date: 2020/4/28 13:12
 * description:
 */
@Component
public class ProducerServiceFallbackFactory implements FallbackFactory<ProducerService> {

    @Override
    public ProducerService create(Throwable throwable) {
        return new ProducerService() {
            @Override
            public String message() {
                return "message not linking";
            }

            @Override
            public String showName(String name) {
                return "showName not linking";
            }

            @Override
            public List<Student> findStudentAll() {
                return new ArrayList<>();
            }
        };
    }
}
