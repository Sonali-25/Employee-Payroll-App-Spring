package com.example.emppayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmpPayrollAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpPayrollAppApplication.class, args);
        log.info("Employee Payroll App Started");
    }

}
