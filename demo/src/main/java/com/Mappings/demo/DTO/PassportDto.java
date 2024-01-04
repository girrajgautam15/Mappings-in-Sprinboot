package com.Mappings.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PassportDto {
    private Integer pass_id;

    private String passportNumber;
    @JsonIgnore
    private StudentDto student;

    public PassportDto() {
    }

    public PassportDto(Integer pass_id, String passportNumber) {
        this.pass_id = pass_id;
        this.passportNumber = passportNumber;
        // this.student = student;
    }

    public PassportDto(Integer pass_id, String passportNumber, StudentDto student) {
        this.pass_id = pass_id;
        this.passportNumber = passportNumber;
        this.student = student;
    }

    public Integer getPass_id() {
        return pass_id;

    }

    public void setPass_id(Integer pass_id) {
        this.pass_id = pass_id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

}
