package com.example.emppayrollapp.service;

import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayroll();
      EmployeePayrollData getEmployeePayrollDataById(int employeeId);
      EmployeePayrollData createEmployeePayrollData(EmpPayrollDTO employeePayrollDto);
      EmployeePayrollData updateEmployeePayrollData(EmpPayrollDTO employeePayrollDto);
      void deleteEmployeePayrollDataById(int employeeId);
}
