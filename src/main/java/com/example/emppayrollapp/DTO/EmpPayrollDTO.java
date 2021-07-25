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

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
