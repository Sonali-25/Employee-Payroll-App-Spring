package com.example.emppayrollapp.DTO;

public class EmpPayrollDTO {
    private String name;
    private long salary;

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
