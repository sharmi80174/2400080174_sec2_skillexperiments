package com.klu.course_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.course_api.entity.Course;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course updateCourse(int id, Course course) {

        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(course.getTitle());
                c.setDuration(course.getDuration());
                c.setFee(course.getFee());
                return c;
            }
        }

        return null;
    }

    public boolean deleteCourse(int id) {

        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchCourse(String title) {

        List<Course> result = new ArrayList<>();

        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        return result;
    }
}