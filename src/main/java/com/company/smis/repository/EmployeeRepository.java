package com.company.smis.repository;

import com.company.smis.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//List<Employee> findByFirstname(String firstname);

List<Employee> findByEmail(String email);


}
