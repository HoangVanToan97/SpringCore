package vn.hust.config;

import org.springframework.context.annotation.Bean;

import vn.hust.repository.StudentRepository;
import vn.hust.service.StudentService;

public class ApplicationConfig {
	
	@Bean("studentRepository")
	public StudentRepository getStudentRepository() {
		return new StudentRepository();
	}
	
	@Bean("studentService")
	public StudentService getStudentService() {
		return new StudentService();
	}

}
