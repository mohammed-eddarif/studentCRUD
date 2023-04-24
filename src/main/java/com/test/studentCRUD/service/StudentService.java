package com.test.studentCRUD.service;

import com.test.studentCRUD.entity.StudentEntity;
import com.test.studentCRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> listAll(){
        return studentRepository.findAll();
    }

    public void save(StudentEntity student){
        studentRepository.save(student);
    }

    public StudentEntity get(Long id){
        return studentRepository.findById(id).get();
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }


}
