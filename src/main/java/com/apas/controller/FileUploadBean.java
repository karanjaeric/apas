/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.controller;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author ekaranja
 */
public class FileUploadBean {
    
     private CommonsMultipartFile file;
 
    public CommonsMultipartFile getFile() {
        return file;
    }
 
    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }
    
}
