/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.model;

/**
 *
 * @author ekaranja
 */
public class ExtJSFormResult {
    
    private boolean success;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String toString(){
		return "{success:"+this.success+"}";
}
    
}
