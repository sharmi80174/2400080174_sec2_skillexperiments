package com.klu.course_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.course_api.entity.Course;
import com.klu.course_api.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course) {

        service.addCourse(course);
        return new ResponseEntity<>("Course Added", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if (updated != null)
            return new ResponseEntity<>(updated, HttpStatus.OK);

        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (deleted)
            return new ResponseEntity<>("Course Deleted", HttpStatus.OK);

        return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {

        return new ResponseEntity<>(service.searchCourse(title), HttpStatus.OK);
    }
}