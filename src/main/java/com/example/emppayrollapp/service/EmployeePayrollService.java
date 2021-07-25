package com.example.emppayrollapp.service;


import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{


    public List<EmployeePayrollData> getEmployeePayroll(){
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1,new EmpPayrollDTO("Sonali",50000)));
        return empDataList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmpPayrollDTO("Sonam",55000));
        return empData;
    }

    public EmployeePayrollData createEmployeePayrollData(EmpPayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDTO);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,employeePayrollDto);
        return empData;
    }
    public void deleteEmployeePayrollDataById(int employeeId){

    }

}
