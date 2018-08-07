/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.dao;

import com.apas.Employee;
import com.apas.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class EmployeeDao {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    //save an employee
    public Employee save(Employee emp){
        return employeeRepository.save(emp);
    }
    
    //search all employee
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    
    //get an employee by Id
    public Employee findOne(Long empId){
        return employeeRepository.getOne(empId);
    }
    
    //delete an employee 
    public void delete(Employee emp){
    employeeRepository.delete(emp);
    }
    
    
    
    
}
