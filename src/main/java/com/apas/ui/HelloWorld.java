package com.apas.ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@ManagedBean(name = "helloWorld", eager = true)
@ViewScoped 
public class HelloWorld extends SpringBeanAutowiringSupport {

    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World!";
    }

}
