/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author ekaranja
 */
@ManagedBean(name = "fileUploadView", eager = true)
@ViewScoped
public class FileUploadView {

    private final String destination = "/home/ekaranja/Music/pas/";

    public void handleFileUpload(FileUploadEvent event) {

        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            try ( // write the inputStream to a FileOutputStream
                    OutputStream out = new FileOutputStream(new File(destination + fileName))) {
                int read = 0;
                byte[] bytes = new byte[1024];
                
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                
                in.close();
                out.flush();
            }

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
