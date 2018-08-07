/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.controller;

import com.apas.Employee;
import com.apas.dao.EmployeeDao;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ekaranja
 */
@RestController
@RequestMapping("/company")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //save employee into database
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
        return employeeDao.save(emp);

    }

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
    
    //get employee by Id
     @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable(value="id") Long empId) {
        Employee employee= employeeDao.findOne(empId);
        if(employee==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(employee);

    }
    
    //update an employee by employee id
    
    @PutMapping("/employees/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empId,@Valid @RequestBody Employee empDetails){
          Employee employee= employeeDao.findOne(empId);
        if(employee==null)
            return ResponseEntity.notFound().build();
        else{
            employee.setName(empDetails.getName());
            employee.setExpertise(empDetails.getExpertise());
            employee.setDesignation(empDetails.getDesignation());
            Employee updatedEnployee=employeeDao.save(employee);
             return ResponseEntity.ok().body(updatedEnployee);
            
        
        }
            
    }

/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
}
    

}
