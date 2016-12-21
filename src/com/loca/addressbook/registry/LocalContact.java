package com.loca.addressbook.registry;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Ola on 2016-12-20.
 */
public class LocalContact implements Contact, Serializable {

    private UUID id;
    private ContactDetails contactDetails;

    public LocalContact(String firstName, String lastname, String email, UUID id ) {
        this.id = id;
        contactDetails = new ContactDetails(firstName,lastname,email);
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String getFirstName() {
        return contactDetails.getFirstName();
    }

    @Override
    public String getLastName() {
        return contactDetails.getLastName();
    }

    @Override
    public String getEmailAddress() {
        return contactDetails.getEmail();
    }
}
