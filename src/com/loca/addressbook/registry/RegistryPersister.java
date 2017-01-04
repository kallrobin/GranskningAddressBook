package com.loca.addressbook.registry;

import com.loca.addressbook.userinterface.Console;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistryPersister {
    private static final Logger log = Logger.getLogger(RegistryPersister.class.getName());

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
                log.log(Level.SEVERE, Thread.currentThread().getName() + ": InterruptedException caught in thread", e);
            }
        }
    }

    public synchronized void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("contacts.data");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(registry.getContacts());
        } catch (IOException e) {
            log.log(Level.SEVERE, Thread.currentThread().getName() + ": IOException caught in thread", e);
        }
    }
}

