/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.controller;

import com.apas.Employee;
import com.apas.dao.EmployeeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ekaranja
 */
@RestController
@RequestMapping("/")
public class UploadController {
        @Autowired
    EmployeeDao employeeDao;

    @PostMapping("/upload")
    public @ResponseBody String res(FileUploadBean uploadItem) {
       return "testing";

    }

}
