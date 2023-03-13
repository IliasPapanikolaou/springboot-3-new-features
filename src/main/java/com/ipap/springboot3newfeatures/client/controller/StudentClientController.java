package com.ipap.springboot3newfeatures.client.controller;

import com.ipap.springboot3newfeatures.client.StudentClientService;
import com.ipap.springboot3newfeatures.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client/students")
public class StudentClientController {

    private final StudentClientService studentClientService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentClientService.getAllStudents();
    }
}
