package com.creditcard.app.ccapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com")
@SpringBootApplication
public class CcappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcappApplication.class, args);
    }

}

