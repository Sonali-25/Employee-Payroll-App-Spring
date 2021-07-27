package com.example.emppayrollapp.service;


import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import com.example.emppayrollapp.exception.EmployeePayrollException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayroll() {
        return employeePayrollDataList;
    }
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId){
        return employeePayrollDataList.stream()
                .filter(employeePayrollData -> employeePayrollData.getEmployeeId() == employeeId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmpPayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(employeePayrollDataList.size()+1,employeePayrollDTO);
        this.employeePayrollDataList.add(empData);
        return empData;
    }

    public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        empData.setName(employeePayrollDto.getName());
        empData.setSalary(employeePayrollDto.getSalary());
        this.employeePayrollDataList.set(employeeId-1, empData);
        return empData;
    }
    public void deleteEmployeePayrollDataById(int employeeId){
        employeePayrollDataList.remove(employeeId-1);

    }

}
