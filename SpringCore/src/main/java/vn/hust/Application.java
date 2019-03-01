package vn.hust;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.hust.config.ApplicationConfig;
import vn.hust.service.StudentService;

public class Application {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		StudentService studentService = context.getBean("studentService", StudentService.class);
		System.out.println(studentService.outputStudent().size());
	}

}
