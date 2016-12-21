package com.loca.addressbook.remoteregistry;

import com.loca.addressbook.registry.Contact;
import com.loca.addressbook.registry.UniqueIdGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 2016-12-20.
 */
public class RemoteRegistry {

    List<RemoteContact> remoteRegistry = new ArrayList<>();


    public List<RemoteContact> getContacts() {
        return remoteRegistry;
    }

    public List<RemoteContact> search(String search) {
        List<RemoteContact> tempRegistry = new ArrayList <>();
        for (RemoteContact contact : remoteRegistry){
            if(contact.getFirstName().toLowerCase().startsWith(search) ||
                    contact.getLastName().toLowerCase().startsWith(search)){
                tempRegistry.add(contact);
            }
        }
        return tempRegistry;
    }

    public void add(String id, String firstName, String lastName, String email) {

        remoteRegistry.add(new RemoteContact(id, firstName, lastName, email));
    }
}
