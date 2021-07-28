package com.example.emppayrollapp.service;


import com.example.emppayrollapp.DTO.EmpPayrollDTO;
import com.example.emppayrollapp.entity.EmployeePayrollData;
import com.example.emppayrollapp.exception.EmployeePayrollException;
import com.example.emppayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getEmployeePayroll() {
        return employeePayrollRepository.findAll();
    }
    public EmployeePayrollData getEmployeePayrollDataById(int employeeId){
        return employeePayrollRepository
                .findById(employeeId)
                .orElseThrow(() -> new EmployeePayrollException("Employee With Employee Id "+
                        employeeId + "DoesNot Exists...!!"));
    }

    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        return employeePayrollRepository.findEmployeeByDepartment(department);
    }

    public EmployeePayrollData createEmployeePayrollData(EmpPayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepository.save(empData);
    }

    public EmployeePayrollData updateEmployeePayrollData(int employeeId,EmpPayrollDTO employeePayrollDto){
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        empData.updateEmployeePayrollData(employeePayrollDto);
        return employeePayrollRepository.save(empData);
    }
    public void deleteEmployeePayrollDataById(int employeeId){
        EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
        employeePayrollRepository.delete(empData);

    }

}
