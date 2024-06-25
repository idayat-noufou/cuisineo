package com.ynov.webfullstack.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }

}
