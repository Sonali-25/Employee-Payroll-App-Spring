package com.example.emppayrollapp.controller;

import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.DTO.ResponseDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {

    @GetMapping(value = {"/","","employee"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmpPayrollDTO("Sonali",40000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable ("employeeId") int employeeId){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmpPayrollDTO("Sonali",40000));
        ResponseDTO respDTO = new ResponseDTO("Call For ID Successful",  empData);
        return new ResponseEntity<ResponseDTO>
                (respDTO, HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDto);
        ResponseDTO respDTO = new ResponseDTO
                ("Created Employee Payroll Data Successfully",employeePayrollDto);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll
            (@RequestBody EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDto);
        ResponseDTO respDTO = new ResponseDTO
                ("Updated Employee Payroll Data Successfully",employeePayrollDto);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById
            (@PathVariable("employeeId") int employeeId){
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: "+employeeId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
