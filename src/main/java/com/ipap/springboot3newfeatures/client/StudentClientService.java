package com.ipap.springboot3newfeatures.client;

import com.ipap.springboot3newfeatures.model.Student;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/students")
public interface StudentClientService {

    @GetExchange
    // @PostExchange
    // @DeleteExchange
    List<Student> getAllStudents();

}
