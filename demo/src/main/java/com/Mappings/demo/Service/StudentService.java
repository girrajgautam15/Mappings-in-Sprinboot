package com.Mappings.demo.Service;

import org.springframework.stereotype.Service;

import com.Mappings.demo.DTO.PassportDto;
import com.Mappings.demo.DTO.StudentDto;
import com.Mappings.demo.Model.Passport;
import com.Mappings.demo.Model.Student;
import com.Mappings.demo.Repository.PassportRepo;
import com.Mappings.demo.Repository.StudentRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final PassportRepo passportRepo;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepo studentRepo, PassportRepo passportRepo, ModelMapper modelMapper) {
        super();
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
        this.passportRepo = passportRepo;
    }

    public StudentDto extractedStudentDTO(Student st) {
        return this.modelMapper.map(st, StudentDto.class);
    }

    public Student extractedStudent(StudentDto s) {

        return this.modelMapper.map(s, Student.class);
    }

    public Passport extractedPassport(PassportDto pt) {
        return modelMapper.map(pt, Passport.class);
    }

    public PassportDto extractedPassportDto(Passport p) {

        return this.modelMapper.map(p, PassportDto.class);
    }

    public StudentDto add(StudentDto student) {
        Student studentEntity = extractedStudent(student);
        if (student.getPassport() != null) {
            Passport passportEntity = studentEntity.getPassport();

            studentEntity.setPassport(passportEntity);
            passportEntity.setStudent(studentEntity);
        }
        studentEntity = studentRepo.save(studentEntity);// Save the student and get the updated entity
        return student;
    }

    public StudentDto getAll(Integer id) {
        Student st = this.studentRepo.findById(id).get();
        // StudentDto student = new StudentDto(st.getId(), st.getName(),
        // extractedPassportDto(st.getPassport()));
        return extractedStudentDTO(st);
    }

    public PassportDto getPassport(Integer id) {
        PassportDto p = new PassportDto();
        p = extractedPassportDto(this.passportRepo.findById(106).get());
        return p;
    }

    public PassportDto getPassportByStudent(Integer id) {
        Student st = studentRepo.findById(id).get();
        // return new PassportDto(st.getPassport().getPass_id(),
        // st.getPassport().getPassportNumber());
        // Passport p = st.getPassport();
        return extractedPassportDto(st.getPassport());
    }

    public StudentDto addStudentandPass() {

        return extractedStudentDTO(studentRepo.findById(12).get());
    }

    public List<StudentDto> getStudentDtos() {
        List<Student> students = this.studentRepo.findAll();
        return students.stream().map(student -> extractedStudentDTO(student)).collect(Collectors.toList());
    }
}
