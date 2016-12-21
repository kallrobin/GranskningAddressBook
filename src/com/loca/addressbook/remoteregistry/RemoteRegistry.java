package com.loca.addressbook.remoteregistry;

import com.loca.addressbook.registry.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian on 2016-12-20.
 */
public class RemoteRegistry {

    List<Contact> remoteRegistry = new ArrayList<>();
    CatalogueLoader catalogueLoader = new CatalogueLoader(this);

    public List<Contact> getContacts() {
        return remoteRegistry;
    }

    public List<Contact> search(String search) {
        return null;
    }

    public void add(String id, String firstName, String lastName, String email) {

    }
}
