package com.company.smis.controller;

import com.company.smis.model.Employee;
import com.company.smis.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:8080")

public class EmployeeController {
@Autowired
private EmployeeService employeeService;

@GetMapping("app/employees")
@ResponseStatus(HttpStatus.OK)
    public List<Employee> listAllEmployees(){
    return employeeService.ListEmployees();
}


   @PostMapping("app/employees")
   public void addNewStudent(@RequestBody Employee employee){
    employeeService.addEmployee(employee);
   }



   @GetMapping("/app/employees/{employeeid}")
   @ResponseStatus(HttpStatus.OK)

   public Employee findEmployeeById(@PathVariable("employeeid") Long id){
    return employeeService.getEmployeeById(id);
   }

   @PutMapping("/app/employees/{employeeid}")
   public Employee updateEmployee(@RequestBody Employee employee,@PathVariable("employeeid") Long employeeid){
    Employee e = employeeService.getEmployeeById(employeeid);
    e.setFirstName(employee.getFirstName());
    e.setLastName(employee.getLastName());
    employeeService.addEmployee(e);
    return e;
   }


   @DeleteMapping("/app/employees/{employeeid}")
   public void deleteStudent(@PathVariable("employeei   d") Long id){
       employeeService.deleteEMployee(employeeService.getEmployeeById(id));
   }

   @GetMapping("app/employees/search")
   public void getEmployeeByEmail(@RequestParam String email){
    employeeService.employeeByEMail(email);
   }


   //Dynamic Pages
    /* Sample calling
     * http://localhost:8080/students/pages/?pageSize=10&pageNo=2&sortBy=email
     * http://localhost:8080/students/pages/?pageSize=50&pageNo=1&sortBy=email
     * http://localhost:8080/students/pages/?pageSize=10&pageNo=3&sortBy=firstName
     */
    @GetMapping("employee/pages")
    @ResponseStatus(HttpStatus.OK)
    public Page<Employee> getPages(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        return employeeService.getAllStudent(pageNo, pageSize, sortBy);

    }

}
