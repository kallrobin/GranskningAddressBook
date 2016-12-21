package com.loca.addressbook.userinterface;

import com.loca.addressbook.registry.Contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactListSorter {

    public static List<Contact> sort (List<Contact> contacts) {
        List<Contact> sortedContactList = new ArrayList<>(contacts);
        sortedContactList.sort(Comparator.comparing(contact -> contact.getFirstName().toLowerCase()));
        return sortedContactList;
    }
}