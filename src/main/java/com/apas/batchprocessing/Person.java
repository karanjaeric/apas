//Create a business class
//
//Now that you see the format of data inputs and outputs, you write code to represent a row of data.

package com.apas.batchprocessing;

/**
 *
 * @author ekaranja
 */
public class Person {

    private String lastName;
    private String firstName;

     public Person(){
     
     }
    public Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

   
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
     @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
    
    

}
