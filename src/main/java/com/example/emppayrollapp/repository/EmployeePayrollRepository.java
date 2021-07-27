package com.example.emppayrollapp.repository;

import com.example.emppayrollapp.entity.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}
