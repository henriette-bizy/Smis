package com.company.smis;

import com.company.smis.model.Department;
import com.company.smis.model.Employee;
import com.company.smis.repository.DepartmentRepository;
import com.company.smis.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController

public class SmisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmisApplication.class, args);
	}



    @Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository){
		return args -> {

			Department dp = new Department("SoftwareEngineers");
			departmentRepository.save(dp);

			Department dpt = departmentRepository.findById(1).get();

//
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yy");
//			String date = "20/03/2000";
//			LocalDate localDate = LocalDate.parse(date,formatter);

			Employee emp1 = new Employee(1L,"Javis","Mugabo",07,"javis@gmail.com","javisM","qwerty", LocalDate.now(),"Male");
			Employee emp2 = new Employee(2L,"Joy","Mutoni",02,"joy@gmai.com","joyD","3333",LocalDate.now(),"Female");
			Employee emp3 = new Employee(3L,"Ish","Kevin",02,"kevin@gmail.com","Kevin","1234",LocalDate.now(),"male");



			List<Employee> employees = new ArrayList<Employee>();
			employees.add(emp1);
			employees.add(emp2);
			employees.add(emp3);

			employeeRepository.saveAll(employees);
//			System.out.println("the availabl number of students"+employeeRepository.count());
			employeeRepository.findAll().forEach(System.out::println);
			employeeRepository.deleteById(2L);
//			employeeRepository.findByFirstname("javis").forEach(System.out::println);
		};
	}
//	@GetMapping("/anything/company/agroup/mis/main")
//	public String Hello(){
//		return "Hello world!!!!!!";
//	}
}