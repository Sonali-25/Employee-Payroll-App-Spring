package com.example.emppayrollapp.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmpPayrollDTO {

    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z] {1} [a-zA-z\\s] {2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    public EmpPayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;

    }
    public String getName() {
        return name;
    }
    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
