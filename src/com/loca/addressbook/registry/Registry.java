package com.loca.addressbook.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Registry {

    private List<Contact> localContactList = new ArrayList<>();


    public void addContact(String firstName, String lastName, String email) {

        localContactList.add(new LocalContact(firstName, lastName, email, UUID.randomUUID()));
    }

    public List<Contact> getContacts() {
        return this.localContactList;
    }

    public void deleteContact(String uuid) {
        boolean contactFound = false;
        int i = 0;
        for (Contact contact : localContactList) {
            if (contact.getId().equals(uuid)) {
                localContactList.remove(i);
                contactFound = true;
                break;
            }
            i++;
        }
        if (!contactFound){
            System.out.println("Delete failed! Could not find any contact matching ID: " + uuid + " in local address book.");
        } else{
            System.out.println("Deleted the contact with ID " + uuid + ".");
        }
    }

    public List<Contact> search(String search) {
        List<Contact> tempRegistry = new ArrayList<>();
        for (Contact contact : localContactList) {
            if (contact.getFirstName().toLowerCase().startsWith(search.toLowerCase()) ||
                    contact.getLastName().toLowerCase().startsWith(search.toLowerCase())) {
                tempRegistry.add(contact);
            }
        }
        return tempRegistry;

    }

    public void load(List<Contact> localRegistry) {
        this.localContactList = localRegistry;
    }
}
