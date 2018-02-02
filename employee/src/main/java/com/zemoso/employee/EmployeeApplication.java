package com.zemoso.employee;

import com.zemoso.employee.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		/*Employee emp = new Employee();
		emp.setId("1");
		emp.setEmail("abc.gmail.com");
		emp.setFirstName("Shashwat");
		emp.setLastName("Sinha");
		emp.setRole("Software Developer");
		emp.setLocation("Hyderabad");*/
	}
}
