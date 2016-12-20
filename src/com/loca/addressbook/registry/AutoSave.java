package com.loca.addressbook.registry;

import java.io.IOException;

/**
 * Created by katan on 2016-12-20.
 */
public class AutoSave implements Runnable {

    private RegistryPersister registryPersister;

    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("AutoSave");
        while (true) {
            try {
                Thread.sleep(5000);
                registryPersister.save();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
