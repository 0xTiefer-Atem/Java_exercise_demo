package com.example.mvcdemo.service;

import com.example.mvcdemo.model.Course;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
