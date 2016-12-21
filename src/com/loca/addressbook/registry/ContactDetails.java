package com.loca.addressbook.registry;

/**
 * Created by Ola on 2016-12-20.
 */
public class ContactDetails {

    private  String firstName;
    private  String lastName;
    private  String email;

    public ContactDetails(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
