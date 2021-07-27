package com.example.emppayrollapp.controller;

import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.DTO.ResponseDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import com.example.emppayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"/","","employee"})

    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayroll();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful",empDataList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable int employeeId){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDTO respDTO = new ResponseDTO("Call For ID Successful",  empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@Valid @RequestBody EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(employeePayrollDto);
        ResponseDTO respDTO = new ResponseDTO
                ("Created Employee Payroll Data Successfully",employeePayrollDto);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/put/{employeeId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int employeeId,
            @RequestBody EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(employeeId,employeePayrollDto);
        ResponseDTO respDTO = new ResponseDTO
                ("Updated Employee Payroll Data Successfully",empData);
        return new ResponseEntity<>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById
            (@PathVariable("employeeId") int employeeId){
        employeePayrollService.deleteEmployeePayrollDataById(employeeId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: "+employeeId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
