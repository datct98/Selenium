package com.example.buoi5_jpa.controller;

import com.example.buoi5_jpa.exception.NotFoundException;
import com.example.buoi5_jpa.model.Clasz;
import com.example.buoi5_jpa.model.Course;
import com.example.buoi5_jpa.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private ClassRepository classRepository;



    // getAllCourse
    // insertCourse
    @GetMapping(value = "/course/{id}")
    public ResponseEntity<?> getAllCourse(@PathVariable int id){
        Clasz course = classRepository.findById(id);
        if(course== null) throw new NotFoundException("Not fond class id: "+id);
        Page<Clasz> page = classRepository.findAll(PageRequest.of(0,1, Sort.by("name").descending()));
        return ResponseEntity.ok(page);

    }
}
