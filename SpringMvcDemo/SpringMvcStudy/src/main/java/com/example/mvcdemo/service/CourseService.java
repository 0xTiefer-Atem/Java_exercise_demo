package com.example.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.example.mvcdemo.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
