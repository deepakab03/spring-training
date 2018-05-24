/**
 * 
 */
package com.perot.training.dayfive;

/**
 * @author abrahade
 *
 */
public class PersonName {
    private String firstName;
    private String LastName;
    
    
    public PersonName(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        LastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonName [firstName=" + firstName + ", LastName=" + LastName + "]";
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
