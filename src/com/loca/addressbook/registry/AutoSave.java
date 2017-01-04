package com.loca.addressbook.registry;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoSave implements Runnable {

    private RegistryPersister registryPersister;
    private static final Logger log = Logger.getLogger(AutoSave.class.getName());


    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("AutoSave");
        registryPersister.load();
        while (true) {
            try {
                Thread.sleep(5000);
                registryPersister.save();
            } catch (InterruptedException e) {
                log.log(Level.SEVERE, Thread.currentThread().getName() + ": InterruptedException caught in thread", e);
            }
        }
    }
}
