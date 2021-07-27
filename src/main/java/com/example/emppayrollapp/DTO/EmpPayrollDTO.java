package com.example.emppayrollapp.DTO;

import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public  @ToString class EmpPayrollDTO {


    @Pattern(regexp = "^[A-Z] {1} [a-zA-z\\s] {2,}$",
            message = "Employee name Invalid")
    public String name;

    @Min(value = 500,
            message = "Min wage should be more than 500")
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> department;


    public EmpPayrollDTO(String name, long salary, String gender,
                         LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;

    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public String getNote() {
        return note;
    }
    public String getProfilePic() {
        return profilePic;
    }
    public List<String> getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDto{" +
                "name='" + name + '\'' +
                ", salary=" + salary + '\'' +
                ", gender=" + gender + '\'' +
                ", startDate=" + startDate + '\'' +
                ", note=" + note + '\'' +
                ", profilePic=" + profilePic + '\'' +
                ", department=" + department + '\'' +
                '}';
    }
}
