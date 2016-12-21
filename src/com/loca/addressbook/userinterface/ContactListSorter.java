package com.loca.addressbook.userinterface;

import com.loca.addressbook.registry.Contact;

import java.util.Comparator;
import java.util.List;

public class ContactListSorter {

    public List<Contact> sort (List<Contact> contacts) {
        contacts.sort(Comparator.comparing(contact -> contact.getFirstName().toLowerCase()));
        return contacts;
    }
}
