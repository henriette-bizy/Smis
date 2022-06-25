package com.company.smis.Service;

import com.company.smis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.company.smis.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> ListEmployees(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public Employee  getEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public void deleteEMployee(Employee employee){
       employeeRepository.delete(employee);
    }

    public void employeeByEMail(String email){
 employeeRepository.findByEmail(email);

    }

    public Page<Employee> getAllStudent(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return employeeRepository.findAll(paging);
    }
}
