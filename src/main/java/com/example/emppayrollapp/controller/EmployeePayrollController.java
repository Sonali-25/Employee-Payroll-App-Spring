package com.example.emppayrollapp.controller;

import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {

    @GetMapping(value = {"/","","employee"})
    public ResponseEntity<String> getEmployeePayroll(){
        return new ResponseEntity<String>("!! EmployeePayroll !!", HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<String> getEmployeePayrollById(@PathVariable ("employeeId") int employeeId){
        return new ResponseEntity<String>
                ("EmployeePayroll Id: "+employeeId +" Added Successfully", HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<String> addEmployeePayroll(@RequestBody EmpPayrollDTO employeePayrollDto){
        return new ResponseEntity<String>("Added Successfully "+employeePayrollDto, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<String> updateEmployeePayroll(@RequestBody EmpPayrollDTO employeePayrollDto){
        return new ResponseEntity<String>("Updated Successfully "+employeePayrollDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollById(@PathVariable("employeeId") int employeeId){
        return new ResponseEntity<String>("Deleted"+employeeId+" successfully", HttpStatus.OK);
    }
}
