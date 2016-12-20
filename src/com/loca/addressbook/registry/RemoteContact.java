package com.loca.addressbook.registry;

/**
 * Created by katan on 2016-12-20.
 */
public class RemoteContact implements Contact{
    private String uuid;
    private ContactDetails contactDetails;

    public RemoteContact(String firstName, String lastname, String email ) {
        contactDetails = new ContactDetails(firstName,lastname,email);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }
}
