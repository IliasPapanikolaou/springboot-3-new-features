package com.ipap.springboot3newfeatures.service;

import com.ipap.springboot3newfeatures.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    private final ObservationRegistry observationRegistry;

    public Student addStudent(Student student) {
        studentList.add(student);
        // return student;
        return Observation.createNotStarted("addStudent", observationRegistry)
                .observe(() -> student);
    }

    public List<Student> getAllStudents() {
        // return studentList
        return Observation.createNotStarted("getAllStudents", observationRegistry)
                .observe(() -> studentList);
    }

    public Student getStudent(String id) {
//        return studentList.stream()
//                .filter(student -> student.id().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
        return Observation.createNotStarted("getStudent", observationRegistry)
                .observe(() -> studentList.stream()
                        .filter(student -> student.id().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found")));
    }
}
