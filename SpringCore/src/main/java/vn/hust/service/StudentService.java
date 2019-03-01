package vn.hust.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hust.model.Student;
import vn.hust.repository.StudentRepository;

@Service("studentService")
public class StudentService {
	@Autowired
	private StudentRepository repository;

	public StudentService() {
		super();
	}

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	public boolean addStudent(Student student) {
		return repository.addStudent(student);
	}

	public ArrayList<Student> outputStudent() {
		return repository.getAllStudent();
	}

}
