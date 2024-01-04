package com.Mappings.demo.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.Mappings.demo.DTO.PassportDto;
import com.Mappings.demo.DTO.StudentDto;

import com.Mappings.demo.Model.Student;

import com.Mappings.demo.Service.StudentService;

@RestController
public class AppController {
    @Autowired
    StudentService studentService;
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ModelMapper modelMapper;

    public StudentDto extractedStudentDTO(Student st) {
        return this.modelMapper.map(st, StudentDto.class);
    }

    @PostMapping("/addStudent")
    public StudentDto addStudent(@RequestBody StudentDto student) {

        return studentService.add(student);
    }

    @GetMapping("/all")
    public StudentDto getAll() {
        return studentService.getAll(11);
    }

    @GetMapping("passport")
    public PassportDto getPassport() {
        return this.studentService.getPassport(107);
    }

    @GetMapping("add")
    public StudentDto add() {
        StudentDto st = this.studentService.addStudentandPass();
        logger.info("Passport {}", st.getPassport().getPass_id());
        return st;
    }

    @GetMapping("/getAll")
    public List<StudentDto> getStudentDtos() {

        return this.studentService.getStudentDtos();
    }

    @GetMapping("studpass")
    public PassportDto getPassportByStudent() {
        return this.studentService.getPassportByStudent(11);
    }
}
