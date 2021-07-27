package com.example.emppayrollapp.service;


import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import com.example.emppayrollapp.exception.EmployeePayrollException;
import com.example.emppayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

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
        empData = new EmployeePayrollData(employeePayrollDataList.size()+1,
                employeePayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        this.employeePayrollDataList.add(empData);
        return employeePayrollRepository.save(empData);
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
