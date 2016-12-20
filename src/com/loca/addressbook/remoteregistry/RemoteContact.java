package com.loca.addressbook.remoteregistry;

import com.loca.addressbook.registry.Contact;
import com.loca.addressbook.registry.ContactDetails;

/**
 * Created by katan on 2016-12-20.
 */
public class RemoteContact implements Contact {
    private String uuid;
    private ContactDetails contactDetails;

    public RemoteContact(String firstName, String lastname, String email ) {
        contactDetails = new ContactDetails(firstName,lastname,email);
    }

    @Override
    public String getId() {
        return this.uuid;
    }

    @Override
    public String getFirstName() {
        return contactDetails.firstName;
    }

    @Override
    public String getLastName() {
        return contactDetails.lastName;
    }

    @Override
    public String getEmailAddress() {
        return contactDetails.email;
    }
}
