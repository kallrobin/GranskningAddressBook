package com.loca.addressbook.registry;

import com.loca.addressbook.userinterface.Console;

import java.io.*;
import java.util.List;

public class RegistryPersister {

    private Registry registry;

    public RegistryPersister(Registry register) {
        this.registry = register;
    }

    public void load() {

        File file = new File("contacts.data");

        if (file.isFile() && file.canRead()) {
            try {
                FileInputStream fileIn = new FileInputStream("contacts.data");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                registry.load((List<Contact>) in.readObject());
                in.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("contacts.data");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(registry.getContacts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

